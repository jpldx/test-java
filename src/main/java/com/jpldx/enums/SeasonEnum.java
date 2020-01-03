package com.jpldx.enums;

/**
 * @author chen.xudong
 */
public enum SeasonEnum implements EnumInf
{
    // 创建枚举类的对象
    SPRING("Spring", "春天"){
        @Override
        public void show() {
            System.out.println("我是春天");
        }
    },
    SUMMER("Summer", "夏天"){
        @Override
        public void show() {
            System.out.println("我是夏天");
        }
    },
    AUTUMN("Autumn", "秋天"){
        @Override
        public void show() {
            System.out.println("我是秋天");
        }
    },
    WINTER("Winter", "冬天"){
        @Override
        public void show() {
            System.out.println("我是冬天");
        }
    };

    // 提供类的属性，声明为 private final
    private final String seasonName;
    private final String seasonDesc;

    // 声明为final的属性，在构造器中初始化
    private SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 通过公共方法来调用属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

}

interface EnumInf{
    void show();
}