package net.mcreator.aetheria.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class Omnessence1OnPotionActiveTickProcedure extends AetheriaModElements.ModElement {
	public Omnessence1OnPotionActiveTickProcedure(AetheriaModElements instance) {
		super(instance, 210);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Omnessence1OnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) == ((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).experienceLevel
				: 0))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity)
						.giveExperiencePoints((int) (0.1 * ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
		}
	}
}
