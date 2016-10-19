import java.util.Deque;
import java.util.LinkedList;

/*
Maintain a deque which make the head representing the minimum for the current window.
*/

public class Segment {

	public static int getSegment(int[] nums, int k){
		int n = nums.length;
		int maximum = Integer.MIN_VALUE;
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 0; i < n; i++){
			while(!deque.isEmpty() && deque.peek() < i - k + 1){
				//Throw the head of deque when the minimum value is out of the bound in window
				deque.pollFirst();
			}
			while(!deque.isEmpty() && nums[deque.peekLast()] > nums[i]){
				//Make sure the head always represent the minimum value in current window size
				deque.pollLast();
			}
			deque.addLast(i);
			if(i >= k - 1){
				maximum = Math.max(maximum, nums[deque.peekFirst()]);
			}
		}
		return maximum;
	}

	public static void main(String[] args) { //Test case
		int k = 3;
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

		System.out.println(getSegment(nums, k));
	}

}
