package first_lesson.unionfind;

public interface IUnionFind {
    /**
     * Connects p-th elements to q-th element
     * @param p Index of an element to be connected
     * @param q Index of an element to connect to
     */
    void union(int p, int q);

    /**
     * Checks whether two elements are connected
     * @param p Index of the element
     * @param q Index of another element
     * @return The status of connection
     */
    boolean connected(int p, int q);

    /**
     * Makes a string of current connectivity pattern
     * @return A string representation of _id
     */
    String toString();

    /**
     * Print out the data structure to console
     */
    void print();
}