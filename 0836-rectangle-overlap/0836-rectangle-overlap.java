class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
         // should not be completely right,left.top,bottom
        if(rec1[2]<=rec2[0]||        //rec1 left to rec2
            rec2[2]<=rec1[0]||        //rec2 left to rec1
            rec1[3]<=rec2[1]||        //rec1 is below rec2
            rec2[3]<=rec1[1]){        //rec2 is below rec1
            return false;
        }
        return true;
    }
}