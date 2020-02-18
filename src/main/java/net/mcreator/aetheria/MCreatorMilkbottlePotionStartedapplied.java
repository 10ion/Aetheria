package net.mcreator.aetheria;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsaetheria.ModElement.Tag
public class MCreatorMilkbottlePotionStartedapplied extends Elementsaetheria.ModElement {
	public MCreatorMilkbottlePotionStartedapplied(Elementsaetheria instance) {
		super(instance, 129);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorMilkbottlePotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).clearActivePotions();
	}
}
