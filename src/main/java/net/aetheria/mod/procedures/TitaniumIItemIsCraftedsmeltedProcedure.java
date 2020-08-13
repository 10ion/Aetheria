package net.aetheria.mod.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.aetheria.mod.AetheriaModElements;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class TitaniumIItemIsCraftedsmeltedProcedure extends AetheriaModElements.ModElement {
	public TitaniumIItemIsCraftedsmeltedProcedure(AetheriaModElements instance) {
		super(instance, 166);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TitaniumIItemIsCraftedsmelted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) 1);
	}
}
