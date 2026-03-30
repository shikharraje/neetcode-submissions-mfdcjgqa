class Solution
{
    public int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> maxHeap = heapify(stones);
        while(maxHeap.size() > 1)
        {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int res = Math.abs(first - second);
            if(res != 0)
                maxHeap.add(res);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    private PriorityQueue<Integer> heapify(int[] stones)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int stone : stones)
            maxHeap.add(stone);
        return maxHeap;
    }
}
