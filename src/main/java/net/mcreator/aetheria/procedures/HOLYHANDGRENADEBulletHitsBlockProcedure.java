package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class HOLYHANDGRENADEBulletHitsBlockProcedure extends AetheriaModElements.ModElement {

	public HOLYHANDGRENADEBulletHitsBlockProcedure(AetheriaModElements instance) {
		super(instance, 240);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HOLYHANDGRENADEBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HOLYHANDGRENADEBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HOLYHANDGRENADEBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HOLYHANDGRENADEBulletHitsBlock!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new StringTextComponent("BRING FORTH THE HOLY HAND GRENADE!"));
		}
		if (world instanceof ServerWorld)
			((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(), (int) x, (int) y, (int) z, false));
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 20, Explosion.Mode.BREAK);
		}
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(""),
							world.getWorld().getServer(), null).withFeedbackDisabled(),
					"effect give @e[distance=..10] minecraft:instant_damage  1 4");
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 7, 3, 3, 3, 2);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION_EMITTER, x, y, z, (int) 7, 3, 3, 3, 2);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.LAVA, x, y, z, (int) 7, 3, 3, 3, 2);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 7, 3, 3, 3, 2);
		}

	}

}
