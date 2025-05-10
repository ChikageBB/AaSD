package first_lesson;

import first_lesson.unionfind.*;
import first_lesson.utils.Stopwatch;

public class MainUnionFind {

    /**
     * Perform a test on a data structure
     * @param iUnionDS  A data structure
     * @param pairsToConnect  Indices of elements to connect together
     * @param pairsToCheckConnection Indices of elements to check if they are connected
     */
    public static void testTheDataStructure(IUnionFind iUnionDS,
                                            int[][] pairsToConnect,
                                            int[][] pairsToCheckConnection) {
        Stopwatch watch = new Stopwatch();

        // connect
        for (int[] pair : pairsToConnect) {
            iUnionDS.union(pair[0], pair[1]);
        }

        // check the connection status
        for (int[] pair : pairsToCheckConnection) {
            iUnionDS.connected(pair[0], pair[1]);
        }

        // print out the final connectivity pattern
        iUnionDS.print();

        System.out.printf("%nElapsed time = %f [s]%n", watch.getElapsedTime());
    }

    public static void main(String[] args) {
        // total elements in the set
        int n = 10;
        int[][] pairsToConnect = {{4, 3}, {3, 8}, {9, 4}, {2, 1}, {5, 0}, {7, 2}, {6, 1}, {7, 3}};
        int[][] pairsToCheck = {{0, 1}, {1, 2}, {2, 3}, {0, 9}, {3, 9}};

        // UnionFind data struct based on "Eager" QuickFind algorithm
        System.out.println("\nUnionFind:\n");
        testTheDataStructure(new UnionFind(n), pairsToConnect, pairsToCheck);


        // UnionFind data struct based on "Lazy" QuickUnion algorithm
        System.out.println("\nUnionFindQU:\n");
        testTheDataStructure(new UnionFindQU(n), pairsToConnect, pairsToCheck);

        // UnionFind data struct based on "Lazy" QuickUnion algorithm,
        // with weighted tree size - based connection
        System.out.println("\nUnionFindQUWeighted:\n");
        testTheDataStructure(new UnionFindQUWeighted(n), pairsToConnect, pairsToCheck);

        System.out.println("\nUnionFindQUWeightedPC:\n");
        testTheDataStructure(new UnionFindQUWeightedPC(n), pairsToConnect, pairsToCheck);
    }
}
