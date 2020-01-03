package com.jpldx.enums;

/**
 * 枚举类
 * @author chen.xudong
 */
public class Season
{
    // 提供类的属性，声明为 private final
    private final String seasonName;
    private final String seasonDesc;

    // 声明为final的属性，在构造器中初始化
    private Season(String seasonName,String seasonDesc){
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    // 通过公共方法来调用属性
    public String getSeasonName() {
        return seasonName;
    }
    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 创建枚举类的对象
    public static final Season SPRING=new Season("Spring","春天");
    public static final Season SUMMER=new Season("Summer","夏天");
    public static final Season AUTUMN=new Season("Autumn","秋天");
    public static final Season WINTER=new Season("Winter","冬天");
}
