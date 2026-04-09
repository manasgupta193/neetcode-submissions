class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] curBills = new int[2]; //0: 5s, 1: 10s
        for(int bill: bills) {
            if(bill == 5) {
                curBills[0]++;
            } else if(bill == 10) {
                if(curBills[0] == 0) return false;
                curBills[0]--;
                curBills[1]++;
            } else { //20
                if(curBills[0] == 0 || curBills[0]*5 + curBills[1]*10 < 15) return false;
                if(curBills[1] == 0) {
                    curBills[0] -= 3;
                } else {
                    curBills[0]--;
                    curBills[1]--;
                }
            }
        }
        return true;
    }
}