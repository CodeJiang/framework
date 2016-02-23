package com.jiang.framework.socket.codec;

import java.util.List;

import com.jiang.framework.socket.GameMessage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class DataDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf,
			List<Object> objList) throws Exception {
		if(byteBuf.readableBytes() < 4){
			return ;
		}
		
		byteBuf.markReaderIndex();
		int length = byteBuf.readInt();
		if(byteBuf.readableBytes() < length){
			byteBuf.resetReaderIndex();
			
			return;
		}
		int msgID = byteBuf.readInt();
		byte[] data = new byte[length-4];
		
		byteBuf.readBytes(data);
		
		GameMessage gameMessage = new GameMessage();
		gameMessage.setData(data);
		gameMessage.setMsgID(msgID);
		
		objList.add(gameMessage);
	}


}
