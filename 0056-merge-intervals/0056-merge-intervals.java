class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        List<int[]> list = new ArrayList<>();
        for(int i =0;i<intervals.length;i++){
            if(list.isEmpty() || list.get(list.size()-1)[1] < intervals[i][0]){
                list.add(intervals[i]);
            }else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1] , intervals[i][1]);
            }
        }

        return list.toArray(new int[list.size()][]);

        // O(n^2) 

        // Arrays.sort(intervals, Comparator.comparingInt(a ->a[0]));
        // ArrayList<int[]>list = new ArrayList<>();

        // for(int i =0;i<intervals.length;i++){
        //     int start = intervals[i][0];
        //     int end = intervals[i][1];

        //     // Merge overlapping intervals
        //     while (i + 1 < intervals.length && intervals[i + 1][0] <= end) {
        //         end = Math.max(end, intervals[i + 1][1]);
        //         i++; // Move to the next interval
        //     }

        //     list.add(new int[]{start, end});

        // }

        // return list.toArray(new int[list.size()][]);      
    }
}