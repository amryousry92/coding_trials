package coding.practice;

import java.util.PriorityQueue;

public class SmallestKthElement {

    public static int findKthSmallest(int k, int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(2, (o1, o2) -> o2-o1);
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            System.out.println(minHeap.peek());
        }
        System.out.println("end======================================================================");
        for (int i = 0; i < k-1; i++) {
            int x = minHeap.poll();
            System.out.println(x);
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 12, 3, 5, 2, 6, 7, 2, 465, 7, 22, 4, 6, 32, 1, 4};
        System.out.println(findKthSmallest(3, array));
    }
}
