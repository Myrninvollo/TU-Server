package com.github.tuserver.api.event.world;

import com.github.tuserver.api.event.HandlerList;
import com.github.tuserver.api.world.World;

public class WorldSaveEvent extends WorldEvent {
	private static final HandlerList handlers = new HandlerList();

	public WorldSaveEvent(final World world) {
		super(world);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
