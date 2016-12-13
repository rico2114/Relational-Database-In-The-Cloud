package network;

import java.nio.ByteBuffer;

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


}
