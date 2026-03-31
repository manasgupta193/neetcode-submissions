class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // Compare the start of the window (mid) with the element 
            // immediately after the window (mid + k)
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1; // Window must start further right, mid+k one is better choice
            } else {
                high = mid; // This window or one to the left is better
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}