package com.netty.nio.buffer.bufferprinciple;

import java.nio.ByteBuffer;

/**
 * @author deke
 * @description 缓冲区分配
 * @date 2020/4/20
 */
public class BufferAllocateDemo {

    public static void main(String[] args) {
        /**分配一个指定大小的缓冲区*/
        ByteBuffer buffer = ByteBuffer.allocate(10);

        /**包装一个现有的数组*/
        byte[] bytes = new byte[10];
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes);

        System.out.println(buffer.capacity() == buffer2.capacity());

    }
}
