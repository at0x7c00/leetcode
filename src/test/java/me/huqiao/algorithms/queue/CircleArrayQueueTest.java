package me.huqiao.algorithms.queue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class CircleArrayQueueTest {


    @Test
    public void test(){
        CircleArrayQueue<Integer> q = new CircleArrayQueue<Integer>();
        Assert.assertTrue(q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(12);
        Assert.assertEquals(12,q.size());
        Assert.assertFalse(q.isFull());
        Integer i = q.dequeue();
        Assert.assertEquals(Integer.valueOf(1),i);

        Assert.assertEquals(11,q.size());
        q.enqueue(13);
        Assert.assertEquals(12,q.size());
        System.out.println(q);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        Assert.assertEquals(9,q.size());
        System.out.println(q);
    }

    @Test
    public void testDynamicGrowing() {
         CircleArrayQueue<Integer> q = new CircleArrayQueue<Integer>();
         int i = 0;
         Random r = new Random();
         while(i < 100){
             int x = r.nextInt(100);
             if(x >= 30){
                 q.enqueue(i);
                 System.out.print(" >" + i + "\t");
             }else{
                 Integer w = q.dequeue();
                 System.out.print(" "+(w==null ? "-" : w)+"< \t");
             }
             System.out.println(q);
             i++;
         }
    }

}
