package framework;


import com.jiang.framework.message.MessageProto.Message.MessageID;
import com.jiang.framework.message.UserProto.C_USER_LOGIN;
import com.jiang.framework.socket.GameMessage;
import com.jiang.framework.socket.MessageObj;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientMessageHandler extends SimpleChannelInboundHandler<GameMessage> {
	//static AttributeKey<Connection> key = AttributeKey.newInstance("conn");
	@Override
	protected void messageReceived(ChannelHandlerContext ctx, GameMessage gameMessage) throws Exception {
		/*Connection conn = ctx.attr(key).get();
		if(conn != null){
			GameCommandService.executeCommand(gameMessage);
		}		*/
		if(gameMessage.getMsgID() == MessageID.S_USER_LOGIN_VALUE){
			C_USER_LOGIN.Builder cBuilder = C_USER_LOGIN.newBuilder();
			cBuilder.setUsername("hello");
			MessageObj msgObj = new MessageObj(MessageID.C_USER_LOGIN_VALUE, cBuilder.build().toByteArray());
			ctx.channel().writeAndFlush(msgObj.getBuffData());
		}
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("call this 111");
		C_USER_LOGIN.Builder cBuilder = C_USER_LOGIN.newBuilder();
		cBuilder.setUsername("hello");
		MessageObj msgObj = new MessageObj(MessageID.C_USER_LOGIN_VALUE, cBuilder.build().toByteArray());
		ctx.channel().writeAndFlush(msgObj.getBuffData());
		//GameSocketServer.channelGroup.add(ctx.channel());
	};
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("call this 222");
		//GameSocketServer.channelGroup.remove(ctx.channel());
	};	
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception{
		System.out.println("call this");
		/*Connection connection = new Connection();
		connection.setChannel(ctx.channel());
		 
		ctx.attr(key).set(connection);;*/		
	} 
}
