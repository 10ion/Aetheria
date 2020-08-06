package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class WoodenChairBlockAddedProcedure extends AetheriaModElements.ModElement {

	public WoodenChairBlockAddedProcedure(AetheriaModElements instance) {
		super(instance, 465);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WoodenChairBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WoodenChairBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WoodenChairBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WoodenChairBlockAdded!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (world instanceof World && !world.getWorld().isRemote) {
			Entity entityToSpawn = new ChairEntityEntity.CustomEntity(ChairEntityEntity.entity, world.getWorld());
			entityToSpawn.setLocationAndAngles((x + 0.5), (y + 0.5), (z + 0.5), world.getRandom().nextFloat() * 360F, 0);

			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

			world.addEntity(entityToSpawn);
		}

	}

}
