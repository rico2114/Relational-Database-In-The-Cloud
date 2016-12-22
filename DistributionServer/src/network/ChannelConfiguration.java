package network;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import network.pipeline.header.HeaderDecoder;
import network.pipeline.header.HeaderHandler;

/**
 * Created by Sebastían on 16/12/2016.
 */
public class ChannelConfiguration extends ChannelInitializer<SocketChannel> {

    /**
     * A singleton utility for the channel configuration, the reason for creating a singleton
     * is simply providing quick hot fixes without the need of restarting the server
     */
    private static final ChannelConfiguration CHANNEL_CONFIGURATION = new ChannelConfiguration();

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new HeaderDecoder(), new HeaderHandler());
    }

    /**
     * Gets the singleton instance
     * @return  the channel configuration
     */
    public static final ChannelConfiguration getSingleton() {
        return CHANNEL_CONFIGURATION;
    }

}
