package com.demo.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



/** 
 * 还就是对文件的双向的操作
 * 文件的操作最好是以字节为准
 * 记得可以直接将Long强制转化成int类型的数据
 * @author  Lixy 
 * @date    2015-7-1 下午8:38:30 
 * @version 1.0 
 * @since  
 */
public class TestChanelDemo01 {
    
    public static void main(String[] args) throws Exception {
        String info[] = {"dddd", "dddddd", "ddddddddd", "dddddddddddddddddd", "这个就是一个测试"};
        File file1 = new File("d:" + File.separator + "note.txt");//输入文件
        File file2 = new File("d:" + File.separator + "outnote.txt");//输出文件
        FileOutputStream fos = null;
        FileInputStream fis = null;
        FileChannel fileChannelOut = null;//申明channel对象
        FileChannel fileChannelIn = null;//申明channel对象
        try {
            fos = new FileOutputStream(file2);
            fis = new FileInputStream(file1);
            fileChannelOut = fos.getChannel();//得到输出地通道
            fileChannelIn = fis.getChannel();//输入的通道
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(fileChannelIn.read(buffer) != -1) {
                buffer.flip();
                fileChannelOut.write(buffer);
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fos.close();
            fileChannelIn.close();
            fileChannelOut.close();
        }
    }
    
    /**
     * 在这里简单的先使用FileInputStream  FileOutputStream  这两个类都是支持通道的操作的
     * @throws Exception 
     */
    private static void copyFile() throws Exception {
        File file1 = new File("d:" + File.separator + "testin.txt"); 
        File file2 = new File("d:" + File.separator + "testout.txt"); 
        //首先就是拿到我们的输入输出的文件流
        FileInputStream fis = new FileInputStream(file1);
        //其次需要我们拿到InputStreamReader流
        InputStreamReader reader = new InputStreamReader(fis);
        while(reader.read() != -1) {
            reader.toString();
        }
    }

}
