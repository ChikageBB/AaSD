package first_lesson.unionfind;

public class UnionFindQUWeightedPC extends UnionFindQUWeighted{

    public UnionFindQUWeightedPC(int n){
        super(n);
    }

    @Override
    protected int root(int i) {
        //если i не корень, то переходим к его "родителю" и вызываем root("родитель")
        //возвращаем _id[i]
        //в конечном итоге все элементы будут подвешены к корню
        if (i != _id[i]){
            _id[i] = root(_id[i]);
        }
        return _id[i];
    }
}
