public class Solution {
    // Encodes: ["abc", "de"] -> "3#abc2#de"
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    // Decodes: "3#abc2#de" -> ["abc", "de"]
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // Find where the length number ends
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            
            // Parse the length
            int length = Integer.parseInt(s.substring(i, j));
            i = j + 1; // Move i to the start of the actual string
            
            // Extract the string based on length
            res.add(s.substring(i, i + length));
            i += length; // Move i to the start of the next length metadata
        }
        return res;
    }
}