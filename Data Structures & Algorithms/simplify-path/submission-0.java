class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String dir : components) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.removeLast();
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.addLast(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}