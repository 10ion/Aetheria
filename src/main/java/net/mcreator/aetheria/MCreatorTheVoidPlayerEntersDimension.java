package net.mcreator.aetheria;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

@Elementsaetheria.ModElement.Tag
public class MCreatorTheVoidPlayerEntersDimension extends Elementsaetheria.ModElement {
	public MCreatorTheVoidPlayerEntersDimension(Elementsaetheria instance) {
		super(instance, 143);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTheVoidPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorTheVoidPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorTheVoidPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorTheVoidPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTheVoidPlayerEntersDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setPositionAndUpdate(x, (y + 2002), z);
		world.setBlockState(new BlockPos((int) x, (int) 50, (int) z), MCreatorVoidStone.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) 50, (int) z), MCreatorVoidStone.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) 50, (int) (z - 1)), MCreatorVoidStone.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) 50, (int) (z + 1)), MCreatorVoidStone.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) 50, (int) z), MCreatorVoidStone.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) 50, (int) (z + 1)), MCreatorVoidStone.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) 50, (int) (z - 1)), MCreatorVoidStone.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) 50, (int) (z - 1)), MCreatorVoidStone.block.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) 50, (int) (z + 1)), MCreatorVoidStone.block.getDefaultState(), 3);
	}
}
