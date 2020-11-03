package gateway.outbound.netty4;

import gateway.filter.HttpRequestFilter;
import gateway.filter.NettyHeaderFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

import java.net.URI;

/**
 * @author 61404
 */
public class NettyHttpClientOutboundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String host = "127.0.0.1";
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(
                HttpVersion.HTTP_1_1, HttpMethod.GET, new URI(host).toASCIIString());

        // 构建http请求
        request.headers().set(HttpHeaderNames.HOST, host);
        request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderNames.CONNECTION);
        request.headers().set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());
        HttpRequestFilter filter = new NettyHeaderFilter();
        filter.filter(request, ctx);
        ctx.writeAndFlush(request);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Server channelRead....");
        System.out.println(ctx.channel().remoteAddress()+"->Server :"+msg.toString());
        ctx.write("Server write"+msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("Client,exceptionCaught");
        cause.printStackTrace();
        ctx.close();
    }
}
