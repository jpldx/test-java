package com.jpldx.enums;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chen.xudong
 */
public class TestEnum
{

    @Test
    public void test(){
        Map<String,Integer> map=new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> o:entries){
            System.out.println(o.getKey()+":"+o.getValue());
        }
    }
}
