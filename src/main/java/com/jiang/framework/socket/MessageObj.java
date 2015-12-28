package com.jiang.framework.socket;

import com.jiang.framework.util.CommonUtil;
import com.jiang.framework.util.RandomUtil;

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
		byte discard = (byte) RandomUtil.getRandomNum(1, 5);
		byte[] discardByte = CommonUtil.getDiscardByte(discard);
		int length = 4+discard+1+data.length;
		buffData = ByteBufAllocator.DEFAULT.buffer(length);
		buffData.writeInt(length);
		buffData.writeByte(discard);
		buffData.writeBytes(discardByte);
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
		ReferenceCountUtil.release(buffData);
		buffData = null;
	}
	
}
