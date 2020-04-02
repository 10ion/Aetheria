package net.mcreator.aetheria.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class Omnessence1OnPotionActiveTickProcedure extends AetheriaElements.ModElement {
	public Omnessence1OnPotionActiveTickProcedure(AetheriaElements instance) {
		super(instance, 140);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Omnessence1OnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) != ((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).experienceLevel
				: 0))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity)
						.giveExperiencePoints((int) (0.1 * ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
		}
	}
}
