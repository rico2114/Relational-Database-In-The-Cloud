package core;

import network.Network;

/**
 * Created by Sebastían on 16/12/2016.
 */
public class Server {

    public static void main(String[] args) {
        Network.startUp(NetworkEnvironment.HOST, NetworkEnvironment.PORT);
        final Network network = Network.getNetwork();
    }
}
