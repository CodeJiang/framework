package com.jiang.framework.socket;

import com.jiang.framework.socket.codec.DataDecoder;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel paramC) throws Exception {
		ChannelPipeline pipeline = paramC.pipeline();
		//pipeline.addLast(new LengthFieldBasedFrameDecoder(2048, 0, 4));
		pipeline.addLast(new DataDecoder());
		pipeline.addLast(new GameMessageHandler());
	}
	
}
