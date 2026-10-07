class Solution {
    public int countSetBits(int n){
        int cnt=0;
        while(n>0){
            if((1&n)==1){
                cnt++;
            }
            n>>=1;
        }
        return cnt;
    }
    public int minBitFlips(int start, int goal) {
        return countSetBits(start^goal);
    }
}