package network;

import core.NetworkEnvironment;
import interfaces.Initializable;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sebastían on 16/12/2016.
 */
public class Network implements Initializable<Network, Void> {

    /**
     * Represents the logger used for the network
     */
    private static final Logger LOGGER = Logger.getLogger(Network.class.getName());

    /**
     * Represents the only network instance.
     * There will only be one network instance
     */
    private static Network network;

    /**
     * Represents the HOST of the network
     */
    private final String host;

    /**
     * Represents the PORT of the network
     */
    private final int port;

    /**
     * Represents the asynchronous part of the networking
     */
    private ChannelFuture channelHandler;

    /**
     * Represents the worker group
     */
    private EventLoopGroup workerGroup;

    /**
     * Constructs a network based on a HOST and a PORT
     * @param host  the HOST to be used
     * @param port  the PORT to be used
     */
    private Network(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Attempts to start up the network system based on the HOST and the PORT
     * @param host  the HOST of the network
     * @param port  the PORT of the network
     */
    public static void startUp(final String host, final int port) {
        if (network != null) {
            LOGGER.log(Level.INFO, NetworkEnvironment.NETWORK_ALREADY_RUNNING);
        } else {
            network = new Network(host, port).initialize();
        }
    }

    /**
     * This method attempts to initialize the network
     * @return  null if fails to initialize otherwise the network
     */
    @Override
    public Network initialize() {
        workerGroup = new NioEventLoopGroup();
        final Bootstrap bootstrap = new Bootstrap().group(workerGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.handler(ChannelConfiguration.getSingleton());
        try {
            channelHandler = bootstrap.connect(host, port).sync();
            LOGGER.info("The network has been successfully initialized in the port: " + port + ".");
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
        return this;
    }

    /**
     * Attempts to stop the network
     * @return  null always
     */
    @Override
    public Void stop() {
        try {
            channelHandler.channel().close().sync();
            workerGroup.shutdownGracefully().sync();
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }

    /**
     * Returns the network instance supplied by the network class
     * @return  null if the network hasn't been initialized otherwise the network instance
     */
    public static Network getNetwork() {
        return network;
    }
}
