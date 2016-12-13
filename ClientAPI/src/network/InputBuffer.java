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
     * @return  the bytes with the data
     */
    byte[] readBytes(final int amount) {
        final byte [] data = new byte[amount];
        buffer.get(data, readOffset, amount);
        readOffset += amount;
        return data;
    }
}
