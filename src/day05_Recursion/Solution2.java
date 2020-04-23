package day05_Recursion;

class Solution2 {
    //题解：传入一个链表以及需要删除的元素，元素重复也需要删除,返回删除后的链表
    //使用虚拟头结点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;

        ListNode prev= dummyHead;
        while(prev.next!=null){
            if(prev.next.val==val){
                //执行删除操作
                ListNode target=prev.next;
                prev.next=target.next;
                target.next=null;
            }else {
                prev=prev.next;
            }
            
        }
        return dummyHead.next;
    }
}