class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Create a HashSet to store unique numbers encountered so far.
        // A HashSet provides average O(1) time for add and contains operations.
        Set<Integer> seenNumbers = new HashSet<>();

        // Iterate through each number in the input array.
        for (int num : nums) {
            // Check if the current number has already been added to our set.
            // If it has, it means we've found a duplicate.
            if (seenNumbers.contains(num)) {
                return true; // Duplicate found!
            }
            // If the number is not in the set, add it to mark it as seen.
            seenNumbers.add(num);
        }

        // If the loop completes without finding any duplicates,
        // it means all elements are distinct.
        return false;
    }
}