
import java.util.Iterator;
import java.util.LinkedList;

class Path {

    private int V;
    private LinkedList<Integer> adj[];

    Path(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addNewBranch(int v, int w)
    {
        adj[v].add(w);
    }

    int countPathsUtil(int u, int d, int pathCount)
    {
        if (u == d) {
            pathCount++;
        }

        else {
            Iterator<Integer> i = adj[u].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                pathCount = countPathsUtil(n, d, pathCount);
            }
        }
        return pathCount;
    }

    int countPaths(int s, int d)
    {
        int pathCount = 0;
        pathCount = countPathsUtil(s, d,
                pathCount);
        return pathCount;
    }

    public static void main(String args[])
    {
        Path g = new Path(5);
        g.addNewBranch(0, 1);
        g.addNewBranch(0, 2);
        g.addNewBranch(0, 3);
        g.addNewBranch(1, 3);
        g.addNewBranch(2, 3);
        g.addNewBranch(1, 4);
        g.addNewBranch(2, 4);
        System.out.println(g.countPaths(2, 3));
    }
}
