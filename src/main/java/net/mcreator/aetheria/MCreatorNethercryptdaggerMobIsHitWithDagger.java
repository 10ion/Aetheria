package net.mcreator.aetheria;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsaetheria.ModElement.Tag
public class MCreatorNethercryptdaggerMobIsHitWithDagger extends Elementsaetheria.ModElement {
	public MCreatorNethercryptdaggerMobIsHitWithDagger(Elementsaetheria instance) {
		super(instance, 128);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorNethercryptdaggerMobIsHitWithDagger!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 35, (int) 10, (false), (true)));
	}
}
