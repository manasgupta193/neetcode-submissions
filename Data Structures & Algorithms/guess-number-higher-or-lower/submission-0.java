/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        
        while (low <= high) {
            // Avoid potential integer overflow with (low + high) / 2
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            
            if (res == 0) {
                return mid; // Found it!
            } else if (res == -1) {
                high = mid - 1; // Guess was too high, look in the lower half
            } else {
                low = mid + 1; // Guess was too low, look in the upper half
            }
        }
        return -1;
    }
}