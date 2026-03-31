class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        // An empty string or a string with only non-alphanumeric chars
        // will result in left >= right immediately, returning true, which is correct.
        if (s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer inward until it points to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer inward until it points to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // At this point, s.charAt(left) and s.charAt(right) are alphanumeric (or left >= right)
            // If the characters don't match (after converting to lowercase), it's not a palindrome.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move both pointers inward for the next comparison
            left++;
            right--;
        }

        // If the loop completes, it means all alphanumeric characters matched.
        return true;
    }
}