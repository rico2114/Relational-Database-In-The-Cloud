package network.pipeline.header;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Sebastían on 21/12/2016.
 */
public class HeaderHandler extends ChannelInboundHandlerAdapter {

    /**
     * Represents the correct header revision
     */
    private static final int CORRECT_HEADER_REVISION = 1;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        final ApiRevision revision = (ApiRevision) msg;
        if (revision.getRevision() != CORRECT_HEADER_REVISION) {
            ctx.close();
        } else {

        }
    }
}
