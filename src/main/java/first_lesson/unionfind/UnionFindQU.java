package first_lesson.unionfind;

public class UnionFindQU extends UnionFind {
    //protected int[] _id; // ID of the root (parent) element

    public UnionFindQU(int n) {
        super(n);
        // initially each element's index is its own root:
        // _id is the ID of the root (parent) element
    }

    /**
     * Changes element's parent pointers until reach the root
     * @param i Element's index
     * @return Index of the canonical root element
     */
    protected int root(int i) {
        // chain-like changing the roots
        // while the i-th element index is not an index of its root
        while (i != _id[i]) {
            // to point every other node to its super-parent (the very main parent)
            _id[i] = _id[_id[i]];
            // jump to the root of i-th element
            i = _id[i];
        }
        return i;
    }

    @Override
    // make the p-th element to be a child of q-th element's parent
    // union(4, 3) = 4 is a child of 3's root (parent) element
    protected void callUnion(int p, int q) {
        // get the root elements of q-th and q-th elements
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;

        // make the root of p-the element a child of q-ths parent
        _id[rootP] = rootQ;
    }

    @Override
    protected boolean callConnected(int p, int q) {
        // they have the same root (parent) element
        return root(p) == root(q);
    }
}
