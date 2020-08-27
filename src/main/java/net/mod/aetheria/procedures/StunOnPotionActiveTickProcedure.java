package net.mod.aetheria.procedures;

import net.mod.aetheria.AetheriaModElements;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class StunOnPotionActiveTickProcedure extends AetheriaModElements.ModElement {
	public StunOnPotionActiveTickProcedure(AetheriaModElements instance) {
		super(instance, 744);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure StunOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 2, (int) 255, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 2, (int) 255, (false), (false)));
	}
}
