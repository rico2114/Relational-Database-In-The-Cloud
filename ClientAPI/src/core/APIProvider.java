package core;

import network.ClientSocket;
import network.TCPConnection;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sebastían on 13/12/2016.
 */
public class APIProvider {

    /**
     * Represents the logger used for the api provider
     */
    private static final Logger LOGGER = Logger.getLogger(APIProvider.class.getName());

    /**
     * Represents the {@link TCPConnection connection} used to talk to the distribution server
     */
    private final TCPConnection tcpConnection;

    /**
     * Privatize the constructor to avoid external instantiations of this class
     * @param tcpConnection the tcp connection
     */
    private APIProvider(final TCPConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    /**
     * Attempts to authenticate the customer data into the distribution server
     * @param host
     * @param port
     * @param username
     * @param password
     * @return null if the authentication fails otherwise
     */
    public static APIProvider authenticate(final String host, final short port, final String username, final String password) {
        final TCPConnection connection = TCPConnection.connect(host, port);
        if (connection == null) {
            LOGGER.log(Level.SEVERE, "The connection refused to connect.");
            return null;
        }

        final ClientSocket clientSocket = connection.getClientSocket();

        return new APIProvider(connection);
    }
}
