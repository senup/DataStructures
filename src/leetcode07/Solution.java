package leetcode07;

class Solution {
    public int reverse(int x) {
        //结果
        int result = 0;
        while (x != 0) {
            int newResult = x%10+result*10;
            if ((newResult - x % 10) / 10 != result) {
                return 0;
            }
            result=newResult;
            x/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int reverse = s.reverse(123);
        System.out.println(reverse);
    }

}