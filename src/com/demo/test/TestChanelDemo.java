package com.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



/** 
 * 在这里我们使用fileChanel对文件进行双向的操作
 * 文件的操作最好是以字节为准
 * @author  Lixy 
 * @date    2015-7-1 下午8:38:30 
 * @version 1.0 
 * @since  
 */
public class TestChanelDemo {
    
    public static void main(String[] args) throws Exception {
        String info[] = {"dddd", "dddddd", "ddddddddd", "dddddddddddddddddd", "这个就是一个测试"};
        File file = new File("d:" + File.separator + "out.txt");
        FileOutputStream fos = null;
        FileChannel fileChannel = null;//申明channel对象
        try {
            fos = new FileOutputStream(file);
            fileChannel = fos.getChannel();//得到输出地通道
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            for(int i=0; i<info.length; i++) {
                buffer.put(info[i].getBytes());//将我们的字符串变成我们的字节的数组，在放入我们的缓冲区之中
            }
            buffer.flip();//重设缓冲区
            fileChannel.write(buffer);//输出缓冲区的内容
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fos.close();
            fileChannel.close();
        }
    }
    
    /**
     * 在这里简单的先使用FileInputStream  FileOutputStream  这两个类都是支持通道的操作的
     */
    private static void copyFile() {
//        FileInputStream fis = 
    }

}
