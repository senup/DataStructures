package leetcode26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i=0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }


    public static void main(String[] args) {
        int[] nums ={0,0,1,2,3,3,4,4};
        Solution solution = new Solution();
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
        //5
    }
}