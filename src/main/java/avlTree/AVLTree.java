package avlTree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;


    @Override
    public Tree<T> insert(T value) {
        root = insert(value, root);
        return this;
    }
    // Вставка элемента в дерево
    private Node<T> insert(T value, Node<T> node){
        if (node == null){
            return new Node<>(value); // Дошли до листа - делаем новый узел
        }

        // Сравниваем значения в узлах
        if (value.compareTo(node.getValue()) < 0){
            node.setLeft(insert(value, node.getLeft())); // Идем влево
        }else if (value.compareTo(node.getValue()) > 0){
            node.setRight(insert(value, node.getRight())); // Идем вправо
        }else{
            return node;
        }

        updateHeight(node); // Обновляем высоту узла
        return applyRotation(node); // Балансируем дерево
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }
    // Удаляем узел
    private Node<T> delete(T value, Node<T> node){
        if (node == null){
            return null; // Возвращаем null, если элемент не найден
        }


        if (value.compareTo(node.getValue()) < 0){
            node.setLeft(delete(value, node.getLeft()));
        }else if (value.compareTo(node.getValue()) > 0){
            node.setRight(delete(value, node.getRight()));
        }else{
            //Узел найден
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            // Два потомка - ищем max в левом поддереве
            node.setValue(getMax(node.getLeft()));
            node.setLeft(delete(node.getValue(), node.getLeft()));

        }
        updateHeight(node);
        return applyRotation(node); // балансировка
    }

    @Override
    public void traverse() {
        traversalInOrder(root);
    }

    private void traversalInOrder(Node<T> node){
        if (node == null) return;
        traversalInOrder(node.getLeft());
        System.out.println(node); // Печатаем значения
        traversalInOrder(node.getRight());
    }

    @Override
    public T getMax() {
        if (isEmpty()) return null;
        return getMax(root);
    }

    // Возвращаем максимум в дереве
    public T getMax(Node<T> node){
        if (node.getRight() != null){
            return getMax(node.getRight());
        }
        return node.getValue();
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    // Возвращаем минимум в дереве
    private T getMin(Node<T> node) {
        if (node.getLeft() != null) {
            return getMin(node.getLeft());
        }
        return node.getValue();
    }

    // Проверка на пустоту дерева
    @Override
    public boolean isEmpty() {
        return root == null;
    }


    private Node<T> applyRotation(Node<T> node){
        int balance = balance(node);

        if (balance > 1){
            if (balance(node.getLeft()) < 0){
                node.setLeft(rotateLeft(node.getLeft())); // LR поворот
            }
            return rotateRight(node); // LL поворот
        }
        if (balance < -1) {
            if (balance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight())); // RL поворот
            }
            return rotateLeft(node); // RR поворот
        }
        return node; // Баланс в порядке
    }

    /**
     *         10
     *        /  \
     *       5    20
     *      /
     *     2
     *    /
     *   1
     *
     *   balance (10) = height(5) ( = 2) - height(20) (= 0) = 2 => Перевес вправо
     *
     *  leftNode(10) = 5;
     *  centerNode(5) = null
     *
     *  leftNode.setRight(10) =
     *
     *          5
     *         / \
     *        2   10
     *       /      \
     *      1       20
     *
     *
     */


    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeft();
        Node<T> bufferNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(bufferNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    /**
     *
     *          5
     *         / \
     *        2   10
     *       /     \
     *      1       20
     *               \
     *                30
     *
     *      rightNode(5) = 10
     *      bufferNode(10) = null
     *      rightNode.setLeft(node) = 5
     *      node.setRight(buffered(Node))
     *
     *          10
     *         /  \
     *        5    20
     *       /      \
     *      2        30
     *     /
     *    1
     */


     private Node<T> rotateLeft(Node<T> node) {

        Node<T> rightNode = node.getRight();  // 20
        Node<T> bufferNode = rightNode.getLeft(); // null
        rightNode.setLeft(node);  // 10
        node.setRight(bufferNode); // null
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private void updateHeight(Node<T> node) {
        node.setHeight(Math.max(height(node.getRight()), height(node.getLeft())) + 1);
    }


    private int balance(Node<T> node) {
        return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
    }

    private int height(Node<T> node) {
        return node != null ? node.getHeight() : -1;
    }

    // поиск по корню
    public Node<T> search(T data) {
         if (data == null){
             return null;
         }
         return searchElem(data, root);
    }

    public Node<T> searchElem(T data, Node<T> elem) {


        // если такого элемента нет - null, иначе возвращаем сам элемент
        if (elem == null || elem.getValue().equals(data)){
            return elem;
        }

        int comparison = data.compareTo(elem.getValue());

        if (comparison == 0){
            return elem;
        }
        // если значение меньше, чем у корня, то идем по левой ветке
        else if (data.compareTo(elem.getValue()) < 0){
            return searchElem(data, elem.getLeft());
        }

        // иначе по правой
        return searchElem(data, elem.getRight());
    }
}
