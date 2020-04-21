package net.mcreator.aetheria.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.block.VoidStoneBlock;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class TheVoidPlayerEntersDimensionProcedure extends AetheriaElements.ModElement {
	public TheVoidPlayerEntersDimensionProcedure(AetheriaElements instance) {
		super(instance, 211);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TheVoidPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TheVoidPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TheVoidPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TheVoidPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TheVoidPlayerEntersDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		entity.setPositionAndUpdate(x, (y + 2002), z);
		world.setBlockState(new BlockPos((int) x, (int) 50, (int) z), VoidStoneBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) 50, (int) z), VoidStoneBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) 50, (int) (z - 1)), VoidStoneBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) 50, (int) (z + 1)), VoidStoneBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) 50, (int) z), VoidStoneBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) 50, (int) (z + 1)), VoidStoneBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) 50, (int) (z - 1)), VoidStoneBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) 50, (int) (z - 1)), VoidStoneBlock.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) 50, (int) (z + 1)), VoidStoneBlock.block.getDefaultState(), 3);
	}
}
