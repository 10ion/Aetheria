package net.mcreator.aetheria.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.item.HOLYHANDGRENADEItem;
import net.mcreator.aetheria.AetheriaModElements;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class HOLYHANDGRENADERangedItemUsedProcedure extends AetheriaModElements.ModElement {
	public HOLYHANDGRENADERangedItemUsedProcedure(AetheriaModElements instance) {
		super(instance, 241);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HOLYHANDGRENADERangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(HOLYHANDGRENADEItem.block, (int) (1)).getItem() == p.getItem(),
					(int) 1);
	}
}
