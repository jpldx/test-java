package com.jpldx.recursion;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chen.xudong
 */
public class TestRecursion2
{

    @Test
    public void test(){
//        console(8);
        int res=factorial(4);
        System.out.println(res);
    }

    // 打印问题
    private void console(int n){
        if(n>2){
            console(n-1);
        }else{
            System.out.println("n："+n);
        }
    }

    // 阶乘问题
    private int factorial(int n){
        if(n==1){
            return 1;
        }
        return factorial((n-1))*n;
    }

    @Test
    public void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date(1571533200000L)));
    }
}
