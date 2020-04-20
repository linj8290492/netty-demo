package com.netty.nio.buffer.bufferreadonly;

import java.nio.ByteBuffer;

/**
 * @author deke
 * @description 只读缓冲区
 * @date 2020/4/20
 */
public class ReadOnlyBufferDemo {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        /**初始缓冲区中存入0-9*/
        for (int i = 0,j = buffer.capacity(); i < j; i++) {
            buffer.put((byte) i );
        }

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        for (int i = 0,j = readOnlyBuffer.capacity(); i < j; i++) {
            byte b = readOnlyBuffer.get(i);
            b *=10;
            /**把原来位置的3---->30*/
            readOnlyBuffer.put(i,b);
        }
//        for (int i = 0,j = buffer.capacity(); i < j; i++) {
//            byte b = buffer.get(i);
//            b *=10;
//            /**把原来位置的3---->30*/
//            buffer.put(i,b);
//        }

        readOnlyBuffer.position(0);
        readOnlyBuffer.limit(buffer.capacity());

        while (readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get() + "   " );
        }

    }
}
