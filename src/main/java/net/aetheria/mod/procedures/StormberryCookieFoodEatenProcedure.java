package net.aetheria.mod.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.aetheria.mod.potion.Omnessence1Potion;
import net.aetheria.mod.AetheriaModElements;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class StormberryCookieFoodEatenProcedure extends AetheriaModElements.ModElement {
	public StormberryCookieFoodEatenProcedure(AetheriaModElements instance) {
		super(instance, 535);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure StormberryCookieFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Omnessence1Potion.potion, (int) 1800, (int) 1));
	}
}
