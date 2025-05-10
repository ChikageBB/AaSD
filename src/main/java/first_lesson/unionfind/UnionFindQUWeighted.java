package first_lesson.unionfind;

public class UnionFindQUWeighted extends UnionFindQU {
    protected int[] _size; // _size[i] in the number of elements in a subtree rooted at i
    protected int _n;  // total number of elements

    public UnionFindQUWeighted(int n) {
        super(n);
        // initially each element's index is its own root:
        // _id is the ID of the root (parent) element

        _n = n;
        _size = new int[n];
        for (int i = 0; i < n; i++) {
            _size[i] = 1;
        }
    }

    @Override
    // make the p-th element to be a child of q-th element's parent,
    // connecting
    protected void callUnion(int p, int q) {
        // get the root elements of q-th and q-th elements
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one:
        // if p is smaller than q
        if (_size[rootP] < _size[rootQ]) {
            // then parent(p) = q
            _id[rootP] = rootQ;
            _size[rootQ] += _size[rootP];
        }
        // if p is greater than q
        else {
            // then parent(q) = p
            _id[rootQ] = rootP;
            _size[rootP] += _size[rootQ];
        }
        // decrease total number of trees/clusters/components
        _n--;
    }
}
