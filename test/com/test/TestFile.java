package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/** 
 * @author  Lixy 
 * @date    2015-7-2 上午10:59:52 
 * @version 1.0 
 * @since  
 */
public class TestFile {
    
    @Test
    public void testReadFile() throws IOException {
        File file = new File("d:" + File.separator + "note.txt");
        String testString = FileUtils.readFileToString(file);
        System.out.println(testString);
    }
    
    @Test
    public void testFile() throws Exception {
        File file1 = new File("d:" + File.separator + "note.txt"); 
        File file2 = new File("d:" + File.separator + "testout.txt"); 
        //首先就是拿到我们的输入输出的文件流
        FileInputStream fis = new FileInputStream(file1);
        //其次需要我们拿到InputStreamReader流
        InputStreamReader reader = new InputStreamReader(fis);
        int temp = 0;
        while((temp= reader.read()) != -1) {
            System.out.println((char) temp);;
        }
    }

}
