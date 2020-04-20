package com.netty.nio.buffer.bufferarea;

import java.nio.IntBuffer;

/**
 * @author deke
 * @description 缓冲区
 * @date 2020/4/20
 */
public class IntBufferDemo {
    public static void main(String[] args) {

        /**
         * Buffer: ByteBuffer(MappedByteBuffer),LongBuffer,DoubleBuffer,CharBuffer,FloatBuffer,IntBuffer,ShortBuffer
         * 分配新的int缓冲区，参数为缓冲区容量
         * 新缓冲区的当前位置将为0，其界限（限定位置）为其容量，它具有一个底层实现数组，其数组初始偏移量为0
         * */
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0,j=buffer.capacity(); i < j; i++) {
            int k = 2*(i+1);
            /**将给定整数写入此缓冲区的当前位置，当前位置递增*/
            buffer.put(k);
        }

        /**重设此缓冲区，将限制位置设置为当前位置，然后将当前位置设置为0*/
        buffer.flip();

        /**查看在当前位置和限制位置之间是否存在元素*/
        while (buffer.hasRemaining()){
            /**读取此缓冲区当前位置的整数，然后当前位置递增*/
            int j = buffer.get();
            System.out.println(j+" ");
        }
    }
}
