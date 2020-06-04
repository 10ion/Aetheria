package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class PowederKegExplosionProcedure extends AetheriaModElements.ModElement {

	public PowederKegExplosionProcedure(AetheriaModElements instance) {
		super(instance, 453);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PowederKegExplosion!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PowederKegExplosion!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PowederKegExplosion!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PowederKegExplosion!");
			return;
		}

		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.BREAK);
		}

	}

}
