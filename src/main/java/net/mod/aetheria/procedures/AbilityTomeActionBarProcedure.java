package net.mod.aetheria.procedures;

import net.mod.aetheria.AetheriaModElements;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class AbilityTomeActionBarProcedure extends AetheriaModElements.ModElement {
	public AbilityTomeActionBarProcedure(AetheriaModElements instance) {
		super(instance, 791);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AbilityTomeActionBar!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure AbilityTomeActionBar!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent((("Tome of ") + "" + (((itemstack).getOrCreateTag().getString("abilities"))))), (true));
		}
	}
}
