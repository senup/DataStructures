package day05_Recursion;
//使用递归解决问题
class Solution5 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val==val?head.next:head;
//        if(head.val==val){
//            return head.next;
//        }else {
//            return head;
//        }
    }
}