package network;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by Sebastían on 12/12/2016.
 */
public class Buffer {

    /**
     * Represents the {@link ByteBuffer buffer}
     */
    protected ByteBuffer buffer;

    /**
     * Privately constructs a buffer with a defined size
     * @param size  the size of the buffer
     */
    public Buffer(final int size) {
        this.buffer = ByteBuffer.allocate(size);
    }

    /**
     * Clears the internal buffer
     */
    public void clear() {
        buffer.clear();
    }

    /**
     * Gets the used bytes in the {@link ByteBuffer buffer} array.
     * The offset is defined by the same ByteBuffer class
     * @return  the used bytes
     */
    public byte[] getUsedBytes() {
        final int offset = buffer.arrayOffset();
        final byte [] usedBytes = new byte[offset];
        System.arraycopy(buffer.array(), 0, usedBytes, 0, offset);
        return usedBytes;
    }
}
