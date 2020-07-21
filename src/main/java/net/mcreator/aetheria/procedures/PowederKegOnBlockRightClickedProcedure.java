package net.mcreator.aetheria.procedures;

import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaModElements;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class PowederKegOnBlockRightClickedProcedure extends AetheriaModElements.ModElement {
	public PowederKegOnBlockRightClickedProcedure(AetheriaModElements instance) {
		super(instance, 452);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.FLINT_AND_STEEL, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.FLINT_AND_STEEL, (int) (1)).getItem()))) {
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.BREAK);
			}
		}
	}
}
