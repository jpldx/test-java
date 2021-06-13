package com.jpldx.test.java.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * @author chenxudong
 */
public class TestIO {

    @Test
    public void test() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
//                for(int i = 0; i < cbuf.length; i ++){
//                    System.out.print(cbuf[i]);
//                }

                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void test1() {
        // 1. 提供File类的对象，指明写出到的文件
        File file = new File("hello1.txt");

        // 2. 提供FileWriter对象，用于数据写出
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);

            // 3. 写出数据
            fw.write("I have a dream !");
            fw.write("You have a dream !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4. 流关闭
        finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fw != null)
                        fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        // 1.创建文件
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("logo.jpg");
            File destFile = new File("logo_copy.jpg");

            // 2.创建流
            // 2.1.创建节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            // 2.2.创建处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3.数据读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4.关闭流
        // tip:先关闭外层的流，再关闭内层的流。
        finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello2.txt")));

//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf, 0, len);
//            }

            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4() {
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Test
    public void test5() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.data"));
            oos.writeObject("我爱北京天安门");
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test6() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.data"));
            String str = (String) ois.readObject();
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test7() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile("logo.jpg", "r");
            raf2 = new RandomAccessFile("logo_01.jpg", "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test8() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(3); // 将指针调到下标为3的位置
        // 保存下标3后面的所有数据到StringBuilder中
        StringBuilder sb = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len));
        }
        // 调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.write(sb.toString().getBytes());
    }

    public static void main(String[] args) {
        String hello = "hello";
        for (byte b : hello.getBytes()) {
            System.out.println((char) b);
        }
    }

}
