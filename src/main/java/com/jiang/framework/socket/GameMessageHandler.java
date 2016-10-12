package com.jiang.framework.socket;



import com.jiang.framework.core.GameCommandService;
import com.jiang.framework.core.GameSocketServer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

public class GameMessageHandler extends SimpleChannelInboundHandler<GameMessage> {
	static AttributeKey<Connection> key = AttributeKey.newInstance("conn");  
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, GameMessage gameMessage) throws Exception {
		Connection conn = ctx.attr(key).get();
		if(conn != null){
			gameMessage.setConnection(conn);
			GameCommandService.executeCommand(gameMessage);
		}		
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		GameSocketServer.channelGroup.add(ctx.channel());
	};
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		GameSocketServer.channelGroup.remove(ctx.channel());
		System.out.println("call this====> channelInactive");
	};	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception{
		Connection connection = new Connection();
		connection.setChannel(ctx.channel());
		ctx.attr(key).set(connection);;
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable t){
		t.printStackTrace();
	} 
}
