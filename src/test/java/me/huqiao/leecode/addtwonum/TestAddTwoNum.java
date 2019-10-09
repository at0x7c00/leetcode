package me.huqiao.leecode.addtwonum;

import org.junit.Assert;
import org.junit.Test;

public class TestAddTwoNum {

    @Test
    public void testAddTwoNum(){
        int num1 = 342;
        int num2 = 465;

        ListNode node1 = ListNodeBuilder.build(num1);
        ListNode node2 = ListNodeBuilder.build(num2);

        System.out.println(node1);
        System.out.println(node2);
        ListNode resNode = new AddTwoNum().addTwoNumbers(node1,node2);

        Assert.assertEquals(num1 + num2,resNode.getValue());

    }

    @Test
    public void testAddTwoNum2(){
        int num1 = 5;
        int num2 = 5;

        ListNode node1 = ListNodeBuilder.build(num1);
        ListNode node2 = ListNodeBuilder.build(num2);

        System.out.println(node1);
        System.out.println(node2);
        ListNode resNode = new AddTwoNum().addTwoNumbers(node1,node2);

        Assert.assertEquals(num1 + num2,resNode.getValue());

    }

    @Test
    public void testAddTwoNum3(){
        int num1 = 5;
        int num2 = 55;

        ListNode node1 = ListNodeBuilder.build(num1);
        ListNode node2 = ListNodeBuilder.build(num2);

        System.out.println(node1);
        System.out.println(node2);
        ListNode resNode = new AddTwoNum().addTwoNumbers(node1,node2);

        Assert.assertEquals(num1 + num2,resNode.getValue());

    }

    @Test
    public void testAddTwoNum4(){
        int num1 = 1;
        int num2 = 99;

        ListNode node1 = ListNodeBuilder.build(num1);
        ListNode node2 = ListNodeBuilder.build(num2);

        System.out.println(node1);
        System.out.println(node2);
        ListNode resNode = new AddTwoNum().addTwoNumbers(node1,node2);

        Assert.assertEquals(num1 + num2,resNode.getValue());

    }

}
