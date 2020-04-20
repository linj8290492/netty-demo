package com.netty.nio.buffer.bufferdirect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author deke
 * @description 直接缓冲区
 * @date 2020/4/20
 */
public class BufferDirectDemo {
    public static void main(String[] args) throws Exception {
        /**读取文件中的信息*/
        FileInputStream fin = new FileInputStream("D:\\myself\\file\\netty-nio1.txt");
        /**创建文件的操作管道*/
        FileChannel fc = fin.getChannel();

        /**写入这个文件*/
        FileOutputStream fout = new FileOutputStream("D:\\myself\\file\\netty-nio2.txt");
        /**创建文件的操作管道*/
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true){
            buffer.clear();
            int i = fc.read(buffer);
            if(i==-1){
                break;
            }
            buffer.flip();
            fcout.write(buffer);
        }

    }
}
