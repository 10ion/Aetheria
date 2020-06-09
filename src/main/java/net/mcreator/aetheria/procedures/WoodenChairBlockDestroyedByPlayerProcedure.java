package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class WoodenChairBlockDestroyedByPlayerProcedure extends AetheriaModElements.ModElement {

	public WoodenChairBlockDestroyedByPlayerProcedure(AetheriaModElements instance) {
		super(instance, 466);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WoodenChairBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WoodenChairBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WoodenChairBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WoodenChairBlockDestroyedByPlayer!");
			return;
		}

		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		if (!world.isRemote && world.getServer() != null) {
			world.getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
					"kill @e[tpye=aetheria:chair_entity,distance=..1]");
		}

	}

}
