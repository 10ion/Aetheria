package net.mcreator.aetheria.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.entity.ChairEntityEntity;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class WoodenChairBlockAddedProcedure extends AetheriaModElements.ModElement {
	public WoodenChairBlockAddedProcedure(AetheriaModElements instance) {
		super(instance, 465);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
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
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new ChairEntityEntity.CustomEntity(ChairEntityEntity.entity, world);
			entityToSpawn.setLocationAndAngles((x + 0.5), (y + 0.5), (z + 0.5), world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
	}
}
