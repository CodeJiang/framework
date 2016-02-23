package com.jiang.framework.common;

import com.jiang.framework.socket.GameMessage;
import com.lmax.disruptor.EventFactory;

public class GameEvent {
	private GameMessage gameMessage;
	public GameMessage getGameMessage() {
		return gameMessage;
	}
	public void setGameMessage(GameMessage gameMessage) {
		this.gameMessage = gameMessage;
	}
	public final static EventFactory<GameEvent> EVENT_FACTORY = new EventFactory<GameEvent>() {  
        public GameEvent newInstance() {  
            return new GameEvent();  
        }  
    };  
}
