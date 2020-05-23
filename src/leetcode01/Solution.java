package leetcode01;

import java.util.*;


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current= nums[i];
            int value = target - nums[i];
            if (hashMap.containsKey(value)) {
                res[0] = i;
                res[1] = hashMap.get(value);
                return res;
            } else {
                hashMap.put(current, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={2, 7, 11, 15};
        int[] ints = solution.twoSum(nums, 9);
        System.out.println(ints);
    }
}