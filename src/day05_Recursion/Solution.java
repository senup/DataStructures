package day05_Recursion;

class Solution {
    //题解：传入一个链表以及需要删除的元素，元素重复也需要删除,返回删除后的链表
    //不使用虚拟头结点
    public ListNode removeElements(ListNode head, int val) {
        //头结点被删除
        while(head !=null && head.val==val){
            ListNode delNode = head;
            head = head.next;
            delNode.next=null;
        }
        //链表为空，返回null
        if(head==null){
            return null;
        }

        //中间节点被删除
        //删除链表需要找到其前面的元素
        ListNode prev= head;
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
        return head;
    }
}