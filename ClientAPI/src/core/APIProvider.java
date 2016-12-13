package core;

import network.TCPConnection;

/**
 * Created by Sebastían on 13/12/2016.
 */
public class APIProvider {

    /**
     * Represents the {@link TCPConnection connection} used to talk to the distribution server
     */
    private final TCPConnection tcpConnection;

    /**
     * Privatize the constructor to avoid external instantiations of this class
     */
    private APIProvider() {}

    public static APIProvider authenticate(final String host, final short port, final String username, final String password) {
        // SHA-1 THE PASSWORD AND SEND IT TO THE SERVER, AUTHENTICATION ONLY DONE THROUGH SHA
    }
}
