package net.mcreator.aetheria;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

@Elementsaetheria.ModElement.Tag
public class MCreatorTitaniumIItemIsCraftedsmelted extends Elementsaetheria.ModElement {
	public MCreatorTitaniumIItemIsCraftedsmelted(Elementsaetheria instance) {
		super(instance, 26);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTitaniumIItemIsCraftedsmelted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) 1);
	}
}
