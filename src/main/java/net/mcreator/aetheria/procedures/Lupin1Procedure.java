package net.mcreator.aetheria.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class Lupin1Procedure extends AetheriaElements.ModElement {
	public Lupin1Procedure(AetheriaElements instance) {
		super(instance, 406);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Lupin1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Lupin1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		String player = "";
		if ((((world.getDayTime()) > 13000) && ((world.getDayTime()) < 24000))) {
			if (!entity.world.isRemote && entity.world.getServer() != null) {
				entity.world.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"team add foreignraces");
			}
			if (!entity.world.isRemote && entity.world.getServer() != null) {
				entity.world.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"team join foreignraces @e[type=aetheria:lupin]");
			}
			if (!entity.world.isRemote && entity.world.getServer() != null) {
				entity.world.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"team modify foreignraces collisionRule never");
			}
			if (!entity.world.isRemote && entity.world.getServer() != null) {
				entity.world.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"tp @e[type=aetheria:lupin] @p");
			}
		} else {
			if (!entity.world.isRemote && entity.world.getServer() != null) {
				entity.world.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/kill @e[type=aetheria:lupin]");
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
