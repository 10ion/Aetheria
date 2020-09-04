package net.mod.aetheria.procedures;

import net.mod.aetheria.AetheriaModElements;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class CattailAdditionalGenerationConditionProcedure extends AetheriaModElements.ModElement {
	public CattailAdditionalGenerationConditionProcedure(AetheriaModElements instance) {
		super(instance, 819);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CattailAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CattailAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CattailAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CattailAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double X = 0;
		double Y = 0;
		double Z = 0;
		boolean other_value = false;
		X = (double) (-3);
		other_value = (boolean) (false);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			Y = (double) (-3);
			for (int index1 = 0; index1 < (int) (6); index1++) {
				Z = (double) (-3);
				for (int index2 = 0; index2 < (int) (6); index2++) {
					Z = (double) ((Z) + 1);
				}
				Y = (double) ((Y) + 1);
			}
			X = (double) ((X) + 1);
		}
		return (((world.getBlockState(new BlockPos((int) (x + (X)), (int) (y + (Y)), (int) (z + (Z))))).getBlock() == Blocks.WATER.getDefaultState()
				.getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + (X)), (int) (y + (Y)), (int) (z + (Z))))).getBlock() == Blocks.WATER
						.getDefaultState().getBlock()));
	}
}
