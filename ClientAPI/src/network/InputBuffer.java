package network;

/**
 * Created by Sebastían on 13/12/2016.
 */
public class InputBuffer extends Buffer {

    /**
     * Represents current input read offset
     */
    private int readOffset;

    /**
     * Privately constructs a buffer with a defined size
     * @param size the size of the buffer
     */
    public InputBuffer(final int size) {
        super(size);
    }

    /**
     * Reads x amount of bytes {@code amount} starting from the desired offset
     * @param amount    the amount of bytes to be read
     * @param offset    the offset where you want to start reading
     * @return  the bytes with the data
     */
    byte[] readBytes(final int amount, final int offset) {
        final byte [] data = new byte[amount];
        buffer.get(data, offset, amount);
        return data;
    }
}
