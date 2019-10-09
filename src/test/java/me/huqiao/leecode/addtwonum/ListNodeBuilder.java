package me.huqiao.leecode.addtwonum;

public class ListNodeBuilder {

    public  static ListNode build(int num){
        ListNode res = null;
        ListNode root = null;
        String numStr = num + "";
        for(String n : numStr.split("")){
            if(res!=null){
                res.next = new ListNode(Integer.parseInt(n));
                res = res.next;
            }else{
                res = new ListNode(Integer.parseInt(n));
                root = res;
            }
        }
        return root;
    }

}
