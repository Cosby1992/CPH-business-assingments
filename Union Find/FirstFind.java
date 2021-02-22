
public class FirstFind implements UnionFind {

    private int[] id;
    private int count;


    public FirstFind(int n) {
        id = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {

        int idQ = id[q];
        int idP = id[p];

        for (int i = 0; i < id.length; i++) {
            if(id[i] == idQ) id[i] = idP;
        }

        
        count--;
        throw new UnsupportedOperationException();
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

}