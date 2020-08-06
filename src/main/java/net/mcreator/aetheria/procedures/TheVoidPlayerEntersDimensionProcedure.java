package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class TheVoidPlayerEntersDimensionProcedure extends AetheriaModElements.ModElement {

	public TheVoidPlayerEntersDimensionProcedure(AetheriaModElements instance) {
		super(instance, 213);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
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
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

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
