package net.mcreator.aetheria.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class SporeReservoirMobplayerCollidesBlockProcedure extends AetheriaModElements.ModElement {
	public SporeReservoirMobplayerCollidesBlockProcedure(AetheriaModElements instance) {
		super(instance, 469);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SporeReservoirMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 10, (int) 2));
	}
}
