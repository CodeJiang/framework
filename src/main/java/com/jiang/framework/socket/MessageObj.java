package com.jiang.framework.socket;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCountUtil;

public class MessageObj {
	private int msgID;
	private ByteBuf buffData;
	
	public int getMsgID() {
		return msgID;
	}
	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}
	
	public MessageObj(int msgID, byte[] data){
		this.msgID = msgID;
		int length = 4+data.length;
		//加1024只是测试
		buffData = ByteBufAllocator.DEFAULT.directBuffer(length + 1024);
		buffData.writeInt(length);
		buffData.writeInt(msgID);
		buffData.writeBytes(data);
				
	}
	public ByteBuf getBuffData() {
		return buffData;
	}
	public void setBuffData(ByteBuf buffData) {
		this.buffData = buffData;
	}
	
	public void gc(){
		//ReferenceCountUtil.release(buffData);
		buffData = null;
	}
	
}
