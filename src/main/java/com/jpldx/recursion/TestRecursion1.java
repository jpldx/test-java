package com.jpldx.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.xudong
 */
public class TestRecursion1
{
    //子节点
   private static  List<Menu> childMenu=new ArrayList<Menu>();


    public static void main(String[] args) {
        List<Menu> menuList=new ArrayList<Menu>();
        Menu mu=new Menu("1","目录","0");

        Menu mu1=new Menu("2","目录1","1");
        Menu mu2=new Menu("3","目录1.1","2");
        Menu mu3=new Menu("4","目录1.2","2");

        Menu mu4=new Menu("5","目录2","1");
        Menu mu5=new Menu("6","目录2.1","5");
        Menu mu6=new Menu("7","目录2.2","5");
        Menu mu7=new Menu("8","目录2.2.1","7");

        menuList.add(mu);
        menuList.add(mu1);
        menuList.add(mu2);
        menuList.add(mu3);
        menuList.add(mu4);
        menuList.add(mu5);
        menuList.add(mu6);
        menuList.add(mu7);

        childMenu.clear();
        List<Menu> childList=treeMenuList(menuList,"5");
        for(Menu m:childList){
            System.out.println(m.getId() + "   " + m.getName());
        }
    }

    /**
     * 获取某个父节点下面的所有子节点
     * @param menuList
     * @param id
     * @return
     */
    private static List<Menu> treeMenuList(List<Menu> menuList, String id){
        for(Menu mu: menuList){
            //遍历出父id等于参数的id，add进子节点集合
            if(mu.getPid().equals(id)){
                //递归遍历下一级
                treeMenuList(menuList,mu.getId());
                childMenu.add(mu);
            }
        }
        return childMenu;
    }

}

 class Menu
 {
     private String id;
     private String name;
     private String pid;

     String getId() {
         return id;
     }

     void setId(String id) {
         this.id = id;
     }

     String getName() {
         return name;
     }

     void setName(String name) {
         this.name = name;
     }

     String getPid() {
         return pid;
     }

     void setPid(String pid) {
         this.pid = pid;
     }

     Menu(String id, String name, String pid) {
         this.id = id;
         this.name = name;
         this.pid = pid;
     }
 }

