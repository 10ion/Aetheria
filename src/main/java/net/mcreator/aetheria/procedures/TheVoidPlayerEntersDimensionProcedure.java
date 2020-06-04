package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class TheVoidPlayerEntersDimensionProcedure extends AetheriaModElements.ModElement {

	public TheVoidPlayerEntersDimensionProcedure(AetheriaModElements instance) {
		super(instance, 213);

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

		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(x, (y + 2002), z);
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (y + 2002), z, _ent.rotationYaw, _ent.rotationPitch,
						Collections.emptySet());
			}
		}
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
