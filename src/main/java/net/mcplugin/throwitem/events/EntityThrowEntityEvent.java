package net.mcplugin.throwitem.events;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class EntityThrowEntityEvent extends Event implements Cancellable {

	protected static final HandlerList handlers = new HandlerList();
	protected boolean cancelled;

	protected final Entity thrower;
	protected final Entity throwee;
	protected final float force;

	public EntityThrowEntityEvent(Entity thrower, Entity throwee, float force) {
		this.thrower = thrower;
		this.throwee = throwee;
		this.force = force;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;

	}

	public Entity getThrower() {
		return thrower;
	}

	public Entity getThrowee() {
		return throwee;
	}

	public float getForce() {
		return force;
	}

}
