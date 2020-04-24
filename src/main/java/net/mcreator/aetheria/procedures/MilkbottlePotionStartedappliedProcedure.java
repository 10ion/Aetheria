package net.mcreator.aetheria.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class MilkbottlePotionStartedappliedProcedure extends AetheriaElements.ModElement {
	public MilkbottlePotionStartedappliedProcedure(AetheriaElements instance) {
		super(instance, 204);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MilkbottlePotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).clearActivePotions();
	}
}
