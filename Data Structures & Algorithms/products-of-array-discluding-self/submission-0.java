class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // The output array itself does not count as extra space.
        int[] answer = new int[n];

        // Step 1: Calculate prefix products and store them in the 'answer' array.
        // 'answer[i]' will store the product of all elements to the left of index 'i'.
        // For index 0, there are no elements to the left, so the product is 1.
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // After this loop, 'answer' array holds:
        // answer[0] = 1
        // answer[1] = nums[0]
        // answer[2] = nums[0] * nums[1]
        // ...
        // answer[n-1] = nums[0] * nums[1] * ... * nums[n-2]

        // Step 2: Calculate suffix products and combine them with the prefix products
        // stored in 'answer'. We do this in a single pass from right to left.
        // 'rightProduct' will accumulate the product of all elements to the right of the current index.
        // Initialize 'rightProduct' to 1 as there are no elements to the right of the last element.
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // 'answer[i]' currently holds the product of elements to its left.
            // Multiply it by 'rightProduct' (product of elements to its right) to get the final result for 'answer[i]'.
            answer[i] = answer[i] * rightProduct;

            // Update 'rightProduct' by including the current element 'nums[i]' for the next iteration (to its left).
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }
}