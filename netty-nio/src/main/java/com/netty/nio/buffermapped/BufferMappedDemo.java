package com.netty.nio.buffermapped;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author deke
 * @description 内存缓冲区（I/O映射缓冲区）
 * @date 2020/4/20
 */
public class BufferMappedDemo {
    private static final int start = 0;
    private static final int size = 8;

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\myself\\file\\netty-nio1.txt", "rw");

        /**
         * 把缓冲区跟文件系统进行一个映射关联
         * 只要操作缓冲区里面的内容，文件内容也会跟着改变
         * */
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, start, size);

        mbb.put(0,(byte) 97);
        mbb.put(4,(byte) 122);

        raf.close();

    }

}
