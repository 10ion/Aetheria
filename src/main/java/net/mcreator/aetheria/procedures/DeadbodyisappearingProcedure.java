package net.mcreator.aetheria.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class DeadbodyisappearingProcedure extends AetheriaModElements.ModElement {
	public DeadbodyisappearingProcedure(AetheriaModElements instance) {
		super(instance, 468);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Deadbodyisappearing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity)) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 0)) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "summon aetheria:dead_player_body ~ ~ ~");
					}
				}
			}
		}
	}
}
