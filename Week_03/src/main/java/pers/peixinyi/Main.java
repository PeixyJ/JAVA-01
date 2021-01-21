package pers.peixinyi;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import pers.peixinyi.config.CustomConfig;
import pers.peixinyi.filter.CustomFilter;
import pers.peixinyi.netty.HttpInitializer;

/**
 * @Description:
 * @Author: PeiXy
 * @Date: 2021-01-21 09:30
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int port = Integer.parseInt(System.getProperty("GATEWAY_PORT", "80"));
        EventLoopGroup boos = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup(4);
        //设置Filter配置
        CustomConfig.filterConfig();
        CustomConfig.routerConfig();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 128)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .option(EpollChannelOption.SO_REUSEPORT, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            serverBootstrap.group(boos, work)
                    .channel(NioServerSocketChannel.class)
//                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new HttpInitializer());
            Channel channel = serverBootstrap.bind(port).sync().channel();
            System.out.println("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            channel.closeFuture().sync();
        } finally {
            boos.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}
