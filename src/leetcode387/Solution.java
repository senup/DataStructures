package leetcode387;

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
* */

class Solution {
    public int firstUniqChar(String s) {
        //1.创建空间长度26的数组frequency（频率）
        int[] freq = new int[26];
        //2.遍历每个字符，存放在相应的位置上 重复即加一
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }
        //3.遍历新数组 若查到频率为1的字符 返回该字符索引/下标 否则查询不到返回-1
        for (int i = 0; i < s.length(); i++) {//次数
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int leetcode = s.firstUniqChar("leetcode");
        System.out.println(leetcode);
        int loveleetcode = s.firstUniqChar("loveleetcode");
        System.out.println(loveleetcode);
    }
}