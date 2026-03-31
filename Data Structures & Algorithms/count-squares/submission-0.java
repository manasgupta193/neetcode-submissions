class CountSquares {
    // Maps x-coordinate to a Map of (y-coordinate -> frequency)
    private Map<Integer, Map<Integer, Integer>> points;
    // List to quickly iterate through candidates for the same x-line
    private List<int[]> pointList;

    public CountSquares() {
        points = new HashMap<>();
        pointList = new ArrayList<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        points.computeIfAbsent(x, k -> new HashMap<>())
              .put(y, points.get(x).getOrDefault(y, 0) + 1);
        pointList.add(point);
    }

    public int count(int[] point) {
        int qx = point[0];
        int qy = point[1];
        int ans = 0;

        // Iterate through all added points to find a potential diagonal
        for (int[] p : pointList) {
            int px = p[0];
            int py = p[1];

            // 1. Check if it's a valid diagonal candidate
            // Must have same distance in x and y, and distance > 0
            if (Math.abs(qx - px) != Math.abs(qy - py) || qx == px || qy == py) {
                continue;
            }

            // 2. The other two corners are (qx, py) and (px, qy)
            // We need to see how many times those points exist
            if (points.containsKey(qx) && points.get(qx).containsKey(py) &&
                points.containsKey(px) && points.get(px).containsKey(qy)) {
                
                ans += points.get(qx).get(py) * points.get(px).get(qy);
            }
        }
        return ans;
    }
}