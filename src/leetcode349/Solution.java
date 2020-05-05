package leetcode349;

import java.util.ArrayList;
import java.util.TreeSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        //将第一个数组扔进去，去重
        for (int i = 0; i < nums1.length;i++){
            set.add(nums1[i]);
        }
        //记录交集元素
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length;i++){
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        //返回新数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}