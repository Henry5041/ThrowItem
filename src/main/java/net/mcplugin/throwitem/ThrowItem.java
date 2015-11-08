package net.mcplugin.throwitem;

import net.mcplugin.throwitem.events.EntityThrowEntityEvent;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class ThrowItem {
	private Entity entity;
	private ItemStack stack;
	private float force;

	public ThrowItem(Entity entity, ItemStack stack) {
		this.entity = entity;
		this.stack = stack;
		this.force = 1;
		this.lunch();

	}

	public ThrowItem(Entity entity, ItemStack stack, float force) {
		this.entity = entity;
		this.stack = stack;
		this.force = force;
		this.lunch();

	}

	public void lunch() {
		if (stack.getType() != Material.AIR) {

			Location loc;
			if (entity instanceof LivingEntity) {
				loc = ((LivingEntity) entity).getEyeLocation();
			} else {
				loc = entity.getLocation();
			}
			Vector velocity = loc.getDirection().multiply(force);
			Item item = loc.getWorld().dropItem(loc, stack);
			EntityThrowEntityEvent e = new EntityThrowEntityEvent(entity, item,
					force);

			// Prevent item from being picked up by setting pick up delay.
			item.setPickupDelay(10);
			item.setVelocity(velocity);

			// Make sure the event isn't cancelled.
			if (e.isCancelled())
				item.remove();
		}
	}
}
