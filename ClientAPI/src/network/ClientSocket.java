package network;

import java.net.Socket;

/**
 * Created by Sebastían on 13/12/2016.
 */
public class ClientSocket {

    /**
     * Represents the TCP connection {@link Socket socket}
     */
    private final Socket socket;

    /**
     * Represents the {@link OutputBuffer buffer} used in the output
     */
    private final OutputBuffer outputBuffer;

    /**
     * Represents the {@link InputBuffer buffer} used for reading server input
     */
    private final InputBuffer inputBuffer;

    /**
     * Constructs the client socket with the desired socket and buffers instances
     * @param socket    the socket
     * @param outputBuffer  the output buffer instance
     * @param inputBuffer   the input buffer instance
     */
    public ClientSocket(final Socket socket, final OutputBuffer outputBuffer, final InputBuffer inputBuffer) {
        this.socket = socket;
        this.outputBuffer = outputBuffer;
        this.inputBuffer = inputBuffer;
    }

    /**
     * Gets the {@link OutputBuffer buffer} used in storing the output data
     * @return  the output buffer
     */
    public OutputBuffer getOutputBuffer() {
        return outputBuffer;
    }

    /**
     * Gets the {@link InputBuffer buffer} used for receiving data from the server
     * @return  the buffer
     */
    public InputBuffer getInputBuffer() {
        return inputBuffer;
    }
}
