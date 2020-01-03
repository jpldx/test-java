package com.jpldx.abs;

import org.junit.Test;

/**
 * @author chen.xudong
 */
public class TestFactoryMethod
{

    @Test
    public void test(){
        IWorkFactory i=new StudentWorkFactory();
        i.getWork().doWork();
    }

    interface IWorkFactory{
        Work getWork();
    }
    class StudentWorkFactory implements IWorkFactory{
        @Override
        public Work getWork() {
            return new StudentWork();
        }
    }
    class TeacherWorkFactory implements IWorkFactory{
        @Override
        public Work getWork() {
            return new TeacherWork();
        }
    }

    interface Work{
        void doWork();
    }
    class StudentWork implements Work{
        @Override
        public void doWork() {
            System.out.println("学生写作业");
        }
    }
    class TeacherWork implements Work{
        @Override
        public void doWork() {
            System.out.println("老师批作业");
        }
    }

}
