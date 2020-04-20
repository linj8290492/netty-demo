package com.netty.nio.bufferprinciple;

import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author deke
 * @description Buffer原理
 * @date 2020/4/20
 */
public class BufferPrincipleDemo {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("D:\\myself\\file\\netty-nio1.txt");
        /**创建文件的操作管道*/
        FileChannel fc = fin.getChannel();

        /**分配一个10大小的缓冲区，其实就是分配一个10大小的Byte数组*/
        ByteBuffer buffer = ByteBuffer.allocate(10);
        output("初始化",buffer);

        /**先读一下*/
        fc.read(buffer);
        output("调用read()",buffer);

        /**准备操作之前，先锁定操作范围*/
        buffer.flip();
        output("调用filp()",buffer);

        /**判断有没有可读数据*/
        while (buffer.remaining()>0){
            byte b = buffer.get();
            System.out.println((char)b);
        }
        output("调用get()",buffer);

        /**可以理解为解锁*/
        buffer.clear();
        output("调用clear()",buffer);

        /**最后把管道关闭*/
        fin.close();
    }

    private static void output(String step, Buffer buffer){
        System.out.println(step + " ");
        /**容量，数组大小*/
        System.out.println("capacity:" + buffer.capacity() + ",");
        /**当前操作数据所在的位置，也可以叫做游标*/
        System.out.println("position:" + buffer.position() + ",");
        /**锁定值，flip,数据操作范围索引只能在position - limit 之间*/
        System.out.println("limit:" + buffer.limit() + "\r\n");
    }
}
