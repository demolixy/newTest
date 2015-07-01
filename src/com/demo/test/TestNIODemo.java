package com.demo.test;

import java.nio.IntBuffer;

/** 
 * @author  Lixy 
 * @date    2015-6-30 下午7:30:06 
 * @version 1.0 
 * @since  
 */
public class TestNIODemo {
    
    public static void main(String[] args) {
        //申请一个默认的的缓存区的大小
        IntBuffer buffer = IntBuffer.allocate(10);
        //写入数据之前的limit  capacity position
        System.out.println(buffer.limit() + "---" + buffer.capacity() + "---" + buffer.position());
        buffer.put(7);
        int[] temp = {5,6,6};
        buffer.put(temp);//现在我们的缓冲区中存放的数据是四个记录
        //写入数据之后的几种常量的变化
        System.out.println(buffer.limit() + "---" + buffer.capacity() + "---" + buffer.position());
        
    }

}
