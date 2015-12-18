package com.jiang.framework.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.jiang.framework.common.GameEventHandler;
import com.jiang.framework.common.GameEvent;
import com.jiang.framework.socket.GameMessage;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;




public class DisruptorServer {
	ExecutorService exec = getExecutorSerice();
	Disruptor<GameEvent> disruptor = new Disruptor<GameEvent>(GameEvent.EVENT_FACTORY, 8192, exec,ProducerType.MULTI, new YieldingWaitStrategy());	
	EventHandler<GameEvent> handler = null;
	RingBuffer<GameEvent> ringBuffer = null;
	
	private DisruptorServer(){
		handler = new GameEventHandler();
        GameEventHandler[] gameEventHandler = new GameEventHandler[]{(GameEventHandler) handler};
        disruptor.handleEventsWith(gameEventHandler);
        
        ringBuffer = disruptor.start();
	}
	
	public void addEvent(GameMessage gameMessage){
		long seq = ringBuffer.next();
		try{			
	        GameEvent valueEvent = ringBuffer.get(seq);
	        valueEvent.setGameMessage(gameMessage);
		}finally{
			ringBuffer.publish(seq);
		}
        
        
	}
	
	
	public static ExecutorService getExecutorSerice(){
    	ThreadFactory ft = new ThreadFactory(){
        	private AtomicInteger num = new AtomicInteger(1);
    		@Override
    		public Thread newThread(Runnable r) {
    			Thread t = new Thread(tg,r,"Disruptor_"+num.getAndIncrement());
    			return t;
    		}
    		
    	
    		ThreadGroup tg = new ThreadGroup("DisruptorGroup");
        	
        };
    	return new ThreadPoolExecutor(10, 20, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), ft);
    }
    
     static  class MyThreadFactory implements ThreadFactory{
    	private AtomicInteger num = new AtomicInteger(1);
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(tg,r,"thread 1"+num.getAndIncrement());
			return t;
		}
		
	
		ThreadGroup tg = new ThreadGroup("my thread");
    	
    }
}
