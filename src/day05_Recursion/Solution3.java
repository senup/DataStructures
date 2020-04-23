package day05_Recursion;

class Solution3 {
    //题解：传入一个链表以及需要删除的元素，元素重复也需要删除,返回删除后的链表
    //不使用虚拟头结点
    public ListNode removeElements(ListNode head, int val) {
        //头结点被删除
        while(head !=null && head.val==val){
            head = head.next;
        }
        //链表为空，返回null
        if(head==null){
            return head;
        }

        //中间节点被删除
        //删除链表需要找到其前面的元素
        ListNode prev= head;
        while(prev.next!=null){
            if(prev.next.val==val){
                //执行删除操作
                prev.next=prev.next.next;
            }else {
                prev=prev.next;
            }

        }
        return head;
    }
}