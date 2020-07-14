package net.mcreator.aetheria.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class OinkLivingEntityIsHitWithToolProcedure extends AetheriaModElements.ModElement {
	public OinkLivingEntityIsHitWithToolProcedure(AetheriaModElements instance) {
		super(instance, 493);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure OinkLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure OinkLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure OinkLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OinkLivingEntityIsHitWithTool!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new PigEntity(EntityType.PIG, world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
	}
}
