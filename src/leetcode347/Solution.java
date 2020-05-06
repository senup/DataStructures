package leetcode347;

import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    //频次信息
    private class Frequence implements Comparable<Frequence>{
        int e,freq;

        public Frequence(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Frequence another){
            if (this.freq < another.freq) {
                return -1;
                //在compareTo方法中，
                // 返回1代表当前元素优先级高
            } else if (this.freq > another.freq) {
                return 1;
            }else{
                return 0;
            }
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        //统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num:nums) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        //内置类 默认为最小堆
        PriorityQueue<Frequence> pq = new PriorityQueue<>();
        for (int key:map.keySet()
             ) {
            if (pq.size() < k) {
                pq.add(new Frequence(key, map.get(key)));
            }else if (map.get(key)>pq.peek().freq){
               pq.remove();
                pq.add(new Frequence(key, map.get(key)));
            }
        }
        int[] res = new int[pq.size()];
        for (int i = 0; i < pq.size(); i++) {
            res[i]=pq.remove().e;
        }
        return res;
    }
}