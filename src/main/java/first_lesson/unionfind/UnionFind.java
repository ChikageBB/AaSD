package first_lesson.unionfind;
import first_lesson.utils.Logger;

public class UnionFind implements IUnionFind {
    protected int[] _id; // ID of a cluster that contains connected elements

    /**
     * Create a UnionFind data structure
     * @param n Total number of elements in collection
     */
    public UnionFind(int n) {
        // init an array of indices
        _id = new int[n];

        // fill-up the array:
        // at first, each element's id equal its actual index,
        // so all elements form an individual own cluster
        for (int i = 0; i < n; i++) {
            _id[i] = i;
        }
    }

    @Override
    // make the p-th element to belong to the cluster of the q-th element
    // union(4, 3) = connect 4 to the cluster of 3
    public void union(int p, int q) {
        Logger.writeLine(String.format("union(%d, %d):", p, q));
        Logger.write("before:\t");
        print();

        callUnion(p, q);

        Logger.write("after:\t");
        print();
        Logger.writeLine();
    }

    @Override
    public boolean connected(int p, int q) {
        boolean result = callConnected(p, q);
        Logger.writeLine(String.format("connected(%d, %d) = %b", p, q, result));
        // they belong to the same cluster
        return result;
    }

    /**
     * The "core" of the "Union" method
     * @param p Index of an element to be connected
     * @param q Index of an element to connect to
     */
    protected void callUnion(int p, int q) {
        int pCluster = _id[p];
        int qCluster = _id[q];
        for (int i = 0; i < _id.length; i++) {
            if (_id[i] == pCluster) {
                _id[i] = qCluster;
            }
        }
    }

    /**
     * The "core" of the "Connected" method
     * @param p Index of the element
     * @param q Index of another element
     * @return The status of connection
     */
    protected boolean callConnected(int p, int q) {
        return _id[p] == _id[q];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int id : _id) {
            str.append(id).append(" ");
        }
        return str.toString();
    }

    @Override
    public void print() {
        Logger.writeLine(this.toString());
    }
}
