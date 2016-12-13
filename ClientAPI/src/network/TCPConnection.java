package network;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sebastían on 13/12/2016.
 */
public class TCPConnection {

    /**
     * Defines the default output buffer size with a total of 200 chars available for sending data to the server
     */
    private static final int DEFAULT_OUTPUT_BUFFER_SIZE = Character.BYTES * 200;

    /**
     * Defines the default input buffer size with a total of 200 chars available for reading data
     */
    private static final int DEFAULT_INPUT_BUFFER_SIZE = DEFAULT_OUTPUT_BUFFER_SIZE;

    /**
     * Represents the logger used for the tcp connection
     */
    private static final Logger LOGGER = Logger.getLogger(TCPConnection.class.getName());

    /**
     * Represents the {@link ClientSocket socket} connection to the server
     */
    private final ClientSocket clientSocket;

    /**
     * Private constructor to avoid the class instantiation outside of the static helper methods
     * Constructs a tcp connection based on some configurations
     * @param socket  the socket
     * @param outputBufferSize  the output buffer size
     * @param inputBufferSize   the input buffer size
     */
    private TCPConnection(final Socket socket, final int outputBufferSize, final int inputBufferSize) {
        this.clientSocket = new ClientSocket(socket, new OutputBuffer(outputBufferSize), new InputBuffer(inputBufferSize));
    }

    /**
     * Attempts to connect to a desired host and port, if fails a null will be return
     * @param host  the host to connect to
     * @param port  the port to connect to
     * @param outputBufferSize  the output buffer size
     * @param inputBufferSize   the input buffer size
     * @return  null if the socket connection couldn't be established otherwise a tcp connection instance
     */
    public static TCPConnection connect(final String host, final short port, final int outputBufferSize, final int inputBufferSize) {
        Socket socket;
        try {
            socket = new Socket(host, port);
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, exception.toString(), exception);
            return null;
        }
        return new TCPConnection(socket, outputBufferSize, inputBufferSize);
    }

    /**
     * Attempts to connect to a desired host and port, if fails a null will be return
     * @param host  the host to connect to
     * @param port  the port to connect to
     * @return  null if the socket connection couldn't be established otherwise a tcp connection instance
     */
    public static TCPConnection connect(final String host, final short port) {
        return connect(host, port, DEFAULT_OUTPUT_BUFFER_SIZE, DEFAULT_INPUT_BUFFER_SIZE);
    }
}
