class Solution {
     static int[] reverse(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }
    public int[] findOrder(int n, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
int topo[]=new int[n];
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int inD[]=new int[n];
         for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                inD[it]++;
            }
        }
         Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (inD[i] == 0) {
                q.add(i);
            }
        }
        int j=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();

            topo[j++]=node;
            for(int i: adj.get(node))
            {
                inD[i]--;
                if(inD[i]==0)
                q.add(i);
            }
        }
     if (j == n) return reverse(topo,topo.length);
        int[] arr = {};
        return arr;
    }
}