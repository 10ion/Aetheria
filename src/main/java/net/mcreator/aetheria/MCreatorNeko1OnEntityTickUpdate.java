package net.mcreator.aetheria;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

@Elementsaetheria.ModElement.Tag
public class MCreatorNeko1OnEntityTickUpdate extends Elementsaetheria.ModElement {
	public MCreatorNeko1OnEntityTickUpdate(Elementsaetheria instance) {
		super(instance, 300);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorNeko1OnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		String player = "";
		if (!entity.world.isRemote && entity.world.getServer() != null) {
			entity.world.getServer().getCommandManager()
					.handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "team add foreignraces");
		}
		if (!entity.world.isRemote && entity.world.getServer() != null) {
			entity.world
					.getServer()
					.getCommandManager()
					.handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"team join foreignraces @e[type=aetheria:neko1]");
		}
		if (!entity.world.isRemote && entity.world.getServer() != null) {
			entity.world
					.getServer()
					.getCommandManager()
					.handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"team modify foreignraces collisionRule never");
		}
		if (!entity.world.isRemote && entity.world.getServer() != null) {
			entity.world
					.getServer()
					.getCommandManager()
					.handleCommand(entity.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"tp @e[type=aetheria:neko1,distance=..3] Dev");
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
