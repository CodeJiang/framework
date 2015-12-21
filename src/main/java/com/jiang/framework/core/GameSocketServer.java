package com.jiang.framework.core;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultEventExecutor;

import com.jiang.framework.common.Config;
import com.jiang.framework.socket.ServerInitializer;



public class GameSocketServer {
	
	/**默认是单线程*/
	public static ChannelGroup channelGroup = new DefaultChannelGroup(new DefaultEventExecutor());
	private ServerBootstrap serverBootstrap = null;
	private Channel channel = null;
	
	public void start() throws InterruptedException{
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
        	serverBootstrap = new ServerBootstrap();
        	serverBootstrap.group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .childHandler(new ServerInitializer());
        	
        	serverBootstrap.option(ChannelOption.TCP_NODELAY,true);
        	serverBootstrap.option(ChannelOption.SO_BACKLOG, 1000);
        	serverBootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            
        	channel = serverBootstrap.bind(Config.gamePort).sync().channel();
        	channel.closeFuture().sync();
            
        } finally {
        	System.out.println(" execute close");
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
	}
	
	public void stop(){
		//关闭所有的channel
		channelGroup.close();
		channel.close();
	}
}
