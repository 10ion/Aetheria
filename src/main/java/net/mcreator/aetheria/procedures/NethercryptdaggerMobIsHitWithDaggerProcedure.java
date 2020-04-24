package net.mcreator.aetheria.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class NethercryptdaggerMobIsHitWithDaggerProcedure extends AetheriaElements.ModElement {
	public NethercryptdaggerMobIsHitWithDaggerProcedure(AetheriaElements instance) {
		super(instance, 202);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NethercryptdaggerMobIsHitWithDagger!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 35, (int) 10, (false), (true)));
	}
}
