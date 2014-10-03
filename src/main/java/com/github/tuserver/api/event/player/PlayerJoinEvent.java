package com.github.tuserver.api.event.player;

import com.github.tuserver.api.entity.Player.Player;
import com.github.tuserver.api.event.HandlerList;

public class PlayerJoinEvent extends PlayerEvent {
	private static final HandlerList handlers = new HandlerList();

	public PlayerJoinEvent(Player player) {
		super(player);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}