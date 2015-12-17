package com.jiang.framework.socket.codec;

import java.util.List;

import com.jiang.framework.socket.GameMessage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCountUtil;

public class DataDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf,
			List<Object> objList) throws Exception {		
		int length = byteBuf.readInt();
		byte discard = byteBuf.readByte();
		byteBuf.readerIndex(byteBuf.readerIndex()+discard);
		int msgID = byteBuf.readInt();
		byte[] data = new byte[length-(5+discard)];
		
		byteBuf.readBytes(data);
		
		GameMessage gameMessage = new GameMessage();
		gameMessage.setData(data);
		gameMessage.setMsgID(msgID);
		
		ReferenceCountUtil.release(byteBuf);
	}


}
