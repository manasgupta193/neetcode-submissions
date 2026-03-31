public class Solution {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        // Iterate through each string in the input list.
        for (String s : strs) {
            // Append the length of the current string.
            sb.append(s.length());
            // Append a delimiter (e.g., '#') to separate the length from the string itself.
            sb.append('#');
            // Append the actual string.
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0; // Pointer to current position in the encoded string.

        // Loop while the pointer is within the bounds of the encoded string.
        while (i < s.length()) {
            int delimiterIndex = i;
            // Find the index of the next delimiter '#'.
            // The characters from 'i' to 'delimiterIndex - 1' represent the length.
            while (delimiterIndex < s.length() && s.charAt(delimiterIndex) != '#') {
                delimiterIndex++;
            }

            // Extract the length substring and parse it to an integer.
            // s.substring(i, delimiterIndex) gets the numeric part before '#'.
            int length = Integer.parseInt(s.substring(i, delimiterIndex));

            // Calculate the starting index of the actual string.
            // It's after the delimiter: delimiterIndex + 1.
            int stringStartIndex = delimiterIndex + 1;

            // Extract the actual string using the calculated length.
            // s.substring(stringStartIndex, stringStartIndex + length) gets the actual string.
            String currentString = s.substring(stringStartIndex, stringStartIndex + length);

            // Add the decoded string to our result list.
            decodedStrings.add(currentString);

            // Move the pointer 'i' to the beginning of the next encoded string segment.
            // This is after the current string: stringStartIndex + length.
            i = stringStartIndex + length;
        }

        return decodedStrings;
    }
}