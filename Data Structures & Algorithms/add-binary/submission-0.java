class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int i = m-1, j=n-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int d1 = i>=0 ? a.charAt(i)-'0' : 0;
            int d2 = j>=0 ? b.charAt(j)-'0' : 0;
            sb.append((d1+d2+carry)%2);
            carry = (d1+d2+carry)/2;
            i--; 
            j--;
        }
        if(carry > 0) sb.append("1");
        return sb.reverse().toString();
    }
}