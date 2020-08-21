package net.mod.aetheria.procedures;

import net.mod.aetheria.AetheriaModElements;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class Omnessence1OnPotionActiveTickProcedure extends AetheriaModElements.ModElement {
	public Omnessence1OnPotionActiveTickProcedure(AetheriaModElements instance) {
		super(instance, 286);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
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
						.giveExperiencePoints((int) (0.25 * ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
		}
	}
}
