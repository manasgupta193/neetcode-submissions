class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // Track if we have found the exact target values for each position
        boolean foundA = false, foundB = false, foundC = false;

        for (int[] t : triplets) {
            // Rule: Triplet is only useful if NO element exceeds the target
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                if (t[0] == target[0]) foundA = true;
                if (t[1] == target[1]) foundB = true;
                if (t[2] == target[2]) foundC = true;
            }
            
            // Optimization: If all found, we can stop early
            if (foundA && foundB && foundC) return true;
        }

        return foundA && foundB && foundC;
    }
}