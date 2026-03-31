class TimeMap {
    class Data {
        String val;
        int time;
        Data(String v, int t) { val = v; time = t; }
    }

    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        List<Data> list = map.get(key);
        return binarySearch(list, timestamp);
    }

    private String binarySearch(List<Data> list, int target) {
        int left = 0, right = list.size() - 1;
        String res = "";
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time <= target) {
                // This is a potential candidate, look for something closer to target on the right
                res = list.get(mid).val;
                left = mid + 1;
            } else {
                // Too high, search left
                right = mid - 1;
            }
        }
        return res;
    }
}
