package me.huqiao.leecode.addtwonum;

public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode node = res;
        boolean carry = false;
        while(l1!=null){
            int tmp = l1.val;
            if(carry){
                tmp++;
                carry = false;
            }
            tmp += (l2  == null ? 0 : l2.val);

            if(tmp >= 10){
                carry = true;
                tmp -= 10;
            }

            node.next = new ListNode(tmp);
            node = node.next;

            l1 = l1.next;
            if(l2!=null) {
                l2 = l2.next;
            }
        }

        while(l2!=null){
            int tmp = l2.val;
            if(carry){
                tmp++;
                carry = false;
            }
            if(tmp >= 10){
                carry = true;
                tmp -= 10;
            }
            node.next = new ListNode(tmp);
            node = node.next;
            l2 = l2.next;
        }
        if(carry){
            node.next = new ListNode(1);
        }

        return res.next;
    }
}
