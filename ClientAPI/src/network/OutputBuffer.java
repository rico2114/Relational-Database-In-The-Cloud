package network;

/**
 * Created by Sebastían on 13/12/2016.
 */
public class OutputBuffer extends Buffer {

    /**
     * Privately constructs a buffer with a defined size
     * @param size the size of the buffer
     */
    OutputBuffer(final int size) {
        super(size);
    }

    /**
     * Writes a set of bytes into the buffer
     * @param bytes the bytes to be stored
     * @return  the same caller instance
     */
    public Buffer writeBytes(final byte ... bytes) {
        buffer.put(bytes);
        return this;
    }
}
