package me.huqiao.leecode.addtwonum;


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public int getValue(){
        int unit = 1;
        int value = 0;
        ListNode node = this;
        while(node!=null){
            value += node.val * unit;
            node = node.next;
            unit *= 10;
        }
        return value;
    }
    public String toString(){
        ListNode node = this;
        StringBuffer sb = new StringBuffer();
        while(node!=null){
            sb.append(node.val + "");
            node = node.next;
        }
        return sb.toString();
    }
}
