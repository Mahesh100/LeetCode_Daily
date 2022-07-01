class Solution {
    public int lastStoneWeight(int[] stones) {
        // Build the max heap (in order from largest to smallest)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        // N stones, there will be N-1 Collisions
        for (int i = 0; i < stones.length - 1; i++) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}