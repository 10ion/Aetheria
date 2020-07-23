package net.mcreator.aetheria.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class BedrockreplaceProcedure extends AetheriaModElements.ModElement {
	public BedrockreplaceProcedure(AetheriaModElements instance) {
		super(instance, 215);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Bedrockreplace!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"fill ~-10 0 ~-10 ~10 ~10 ~10 aetheria:bedrock replace minecraft:bedrock");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"fill ~-10 ~-10 ~-10 ~10 ~10 ~10 aetheria:bedrock replace minecraft:bedrock");
			}
		}
	}
}
