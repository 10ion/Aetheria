package net.mcreator.aetheria;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

@Elementsaetheria.ModElement.Tag
public class MCreatorHOLYHANDGRENADERangedItemUsed extends Elementsaetheria.ModElement {
	public MCreatorHOLYHANDGRENADERangedItemUsed(Elementsaetheria instance) {
		super(instance, 200);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorHOLYHANDGRENADERangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(
					p -> new ItemStack(MCreatorHOLYHANDGRENADE.block, (int) (1)).getItem() == p.getItem(), (int) 1);
	}
}
