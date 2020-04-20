package com.netty.nio.bufferslice;

import java.nio.ByteBuffer;

/**
 * @author deke
 * @description 缓冲区分片
 * @date 2020/4/20
 */
public class BufferSliceDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        /**初始缓冲区中存入0-9*/
        for (int i = 0,j = buffer.capacity(); i < j; i++) {
            buffer.put((byte) i );
        }

        /**切出一个子缓冲区，范围是3-7*/
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();

        /**改变子缓冲区中的数据*/
        for (int i = 0,j = slice.capacity(); i < j; i++) {
            byte b = slice.get(i);
            b *=10;
            /**把原来位置的3---->30*/
            slice.put(i,b);
        }

        /**假如不把position重置0，limit重置为capacity，那么最后get的只是子缓冲区中的数据*/
        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining()){
            System.out.println(buffer.get()+ "  ");
        }

    }
}
