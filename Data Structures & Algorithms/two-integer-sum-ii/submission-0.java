class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                // Found the pair. Return 1-indexed indices.
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                // Sum is too small. Need a larger number. Move left pointer to the right.
                left++;
            } else { // currentSum > target
                // Sum is too large. Need a smaller number. Move right pointer to the left.
                right--;
            }
        }
        
        // As per problem constraints, there's always exactly one solution,
        // so this part of the code should ideally not be reached.
        return new int[]{-1, -1}; 
    }
}