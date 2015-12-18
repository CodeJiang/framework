package com.jiang.framework.common;

import com.jiang.framework.core.GameCommandService;
import com.lmax.disruptor.EventHandler;


public class GameEventHandler implements EventHandler<GameEvent> {

	@Override
	public void onEvent(GameEvent gameEvent, long arg1, boolean arg2) throws Exception {
		GameCommandService.executeCommand(gameEvent.getGameMessage());
	}

}
