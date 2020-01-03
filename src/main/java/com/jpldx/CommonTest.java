package com.jpldx;

import com.jpldx.generic.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chen.xudong
 */
public class CommonTest
{
    @Test
    public void test1(){
     List<String> list1=new ArrayList<>();
     list1.add("a");
     list1.add("b");
     List<?> list=list1;

     Iterator<?> it = list.iterator();
     while(it.hasNext()){
         System.out.println(it.next());
     }
    }

    private void add(List<? extends Order> list){

    }

    @Test
    public void test(){
      List<String> list=new ArrayList();
      list.add("a");
      list.add("b");
      list.add("c");
        System.out.println(list);

        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            if("a".equals(it.next())){
                list.remove(it.next());
            }
        }

        System.out.println(list);
    }

    @Test
    public void test2(){
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}
