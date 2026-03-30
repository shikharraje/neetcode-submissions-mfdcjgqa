class KthLargest {

    PriorityQueue<Integer> minHeap;

    int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<Integer>();
        this.k = k;
        for(int num : nums)
        {
            this.minHeap.add(num);
            if(this.minHeap.size() > this.k)
                this.minHeap.poll();
        }
    }
    
    public int add(int val) {
        this.minHeap.add(val);
        if(this.minHeap.size() > this.k)
            this.minHeap.poll();
        return this.minHeap.peek();
    }
}
