package com.jiang.framework.socket;


import com.jiang.framework.core.GameCommandService;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

public class GameMessageHandler extends SimpleChannelInboundHandler<GameMessage> {
	static AttributeKey<Connection> key = AttributeKey.newInstance("conn");  
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, GameMessage gameMessage) throws Exception {
		Connection conn = ctx.attr(key).get();
		if(conn != null){
			GameCommandService.executeCommand(gameMessage);
		}		
	}
	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception{
		Connection connection = new Connection();
		connection.setChannel(ctx.channel());
		 
		ctx.attr(key).set(connection);;
	} 
}
