class Solution {
    public int twoCitySchedCost(int[][] costs) {
        /*
            Priority Queue
        */
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> (x[1] - x[0]) - (y[1] - y[0]));

        // Assume all people are going to city A
        int sum = 0;
        for (int i = 0; i < costs.length; ++i) {
            sum += costs[i][0];
            heap.add(costs[i]);
        }
        
        // heap is sorted based on the cost difference, the smallest (the cost to B - the cost to A) will be at the top
        // so the first half of people in heap should be flying to city B
        // use sum to substract the cost difference
        for (int i = 0; i < costs.length / 2; ++i) {
            int[] temp = heap.poll();
            sum += (temp[1] -temp[0]);
        }
        
        return sum;
    }
}