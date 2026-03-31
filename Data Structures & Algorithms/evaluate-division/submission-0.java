class Solution {
    Map<String, String> parent = new HashMap<>();
    Map<String, Double> ratioToParent = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0), v = queries.get(i).get(1);
            if (!parent.containsKey(u) || !parent.containsKey(v) || !find(u).equals(find(v))) {
                results[i] = -1.0;
            } else {
                results[i] = ratioToParent.get(u) / ratioToParent.get(v);
            }
        }
        return results;
    }

    private String find(String i) {
        if (parent.get(i).equals(i)) return i;
        String oldParent = parent.get(i);
        String root = find(oldParent);
        parent.put(i, root);
        ratioToParent.put(i, ratioToParent.get(i) * ratioToParent.get(oldParent));
        return root;
    }

    private void union(String i, String j, double val) {
        parent.putIfAbsent(i, i); ratioToParent.putIfAbsent(i, 1.0);
        parent.putIfAbsent(j, j); ratioToParent.putIfAbsent(j, 1.0);
        String rootI = find(i), rootJ = find(j);
        if (!rootI.equals(rootJ)) {
            parent.put(rootI, rootJ);
            // i / rootI = rI, j / rootJ = rJ, i / j = val
            // rootI / rootJ = (i / rI) / (j / rJ) = (i / j) * rJ / rI = val * rJ / rI
            ratioToParent.put(rootI, val * ratioToParent.get(j) / ratioToParent.get(i));
        }
    }
}