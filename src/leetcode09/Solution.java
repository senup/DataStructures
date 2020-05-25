package leetcode09;

class Solution {
    public boolean isPalindrome(int x) {
        //如果是负数 不是回文数
        if (x < 0) {
            return false;
        }
        //计算出最高位 如13231的最高位为10000
        int div = 1;
        int num = x;
        while (num / div >= 10) {
            div *= 10;
        }
//        System.out.println("div=>" + div);
        //取出最高位及最低位进行比较
        while (num!=0) {
            int left=num/div;
            int right=num%10;
            if (left != right) {
                return false;
            }
            num=(num-div*left)/10;
            //一次少了两位数
            div/=100;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean result1 = s.isPalindrome(13231);
        //true
        System.out.println(result1);
        boolean result2 = s.isPalindrome(1325631);
        //false
        System.out.println(result2);
    }
}