package gateway.outbound.netty4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;

/**
 * @author 61404
 */
public class NettyHttpClient {

    private String mHost;

    private int mPort;

    public NettyHttpClient(String host, int port) {
        this.mHost = host;
        this.mPort = port;
    }

    public void connect() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            // KeepAlive
            b.option(ChannelOption.SO_KEEPALIVE, true);
            // Handler
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    channel.pipeline().addLast(new HttpClientCodec());
                    channel.pipeline().addLast(new HttpContentDecompressor());
                    channel.pipeline().addLast(new NettyHttpClientOutboundHandler());
                }
            });
            // Start the client.
            ChannelFuture f = b.connect(mHost, mPort).sync();
            if (f.isSuccess()) {
                System.out.println("Client,连接服务端成功");
            }
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 8888;
        NettyHttpClient client = new NettyHttpClient(host, port);
        client.connect();
    }
}
