package network.pipeline.header;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Created by Sebastían on 21/12/2016.
 */
public class HeaderDecoder extends ReplayingDecoder<Void> {

    /**
     * Represents the minimum required bytes.
     * These bytes are used to check te revision of the Api, we ensure
     * that the Api client is up to date
     */
    private static final int MINIMUM_REQUIRED_BYTES = 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < MINIMUM_REQUIRED_BYTES)
            return;

        out.add(new ApiRevision(in.readInt()));
    }
}
