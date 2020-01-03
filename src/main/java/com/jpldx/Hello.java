package com.jpldx;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chen.xudong
 */
public class Hello
{
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimerTask()
        {
            int i=0;
            @Override
            public void run() {
                System.out.println(i++);
            }
        },1000,2000);
    }
}
