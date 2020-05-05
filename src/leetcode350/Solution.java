package leetcode350;

import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int n:nums2) {
            if(map.containsKey(n)){
                list.add(n);
                map.put(n,map.get(n)-1);
                if(map.get(n)==0) {
                    map.remove(n);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}