// left shift
class Solution {
    public boolean isPowerOfTwo(int n)  {
        if (n <= 0) return false; 
        
        for (int i = 0; i < 31; i++) { // 31 because 2^31 exceeds int range
            if ((1 << i) == n) {
                return true;
            }
        }
        return false;
    }
}