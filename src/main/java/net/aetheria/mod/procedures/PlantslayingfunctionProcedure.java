package net.aetheria.mod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.aetheria.mod.AetheriaModElements;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class PlantslayingfunctionProcedure extends AetheriaModElements.ModElement {
	public PlantslayingfunctionProcedure(AetheriaModElements instance) {
		super(instance, 462);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Plantslayingfunction!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure Plantslayingfunction!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((((itemstack).getOrCreateTag().getBoolean("testenchant")) == (true))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) ((0.2 * (((itemstack)).getMaxDamage())) + (((itemstack)).getMaxDamage())));
		}
	}
}
