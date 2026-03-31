/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index);
 * public int length();
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // 1. Find the peak index
        int peak = findPeak(mountainArr, n);
        
        // 2. Search in the ascending part (0 to peak)
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) return index;
        
        // 3. Search in the descending part (peak + 1 to n - 1)
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }
    
    private int findPeak(MountainArray arr, int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1; // Climbing up
            } else {
                high = mid; // Going down
            }
        }
        return low;
    }
    
    private int binarySearch(MountainArray arr, int target, int low, int high, boolean ascending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);
            if (val == target) return mid;
            
            if (ascending) {
                if (val < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (val > target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}