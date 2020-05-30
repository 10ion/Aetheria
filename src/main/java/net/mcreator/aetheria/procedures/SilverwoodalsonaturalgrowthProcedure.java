package net.mcreator.aetheria.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class SilverwoodalsonaturalgrowthProcedure extends AetheriaModElements.ModElement {
	public SilverwoodalsonaturalgrowthProcedure(AetheriaModElements instance) {
		super(instance, 246);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Silverwoodalsonaturalgrowth!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Silverwoodalsonaturalgrowth!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Silverwoodalsonaturalgrowth!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Silverwoodalsonaturalgrowth!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() < 0.005)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if ((Math.random() < 0.33)) {
				if (!world.isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("aetheria", "silverwood3"));
					if (template != null) {
						template.addBlocksToWorldChunk(world, new BlockPos((int) (x + (-3)), (int) y, (int) (z + (-3))), new PlacementSettings()
								.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
					}
				}
			} else {
				if ((Math.random() < 0.33)) {
					if (!world.isRemote) {
						Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("aetheria", "silverwood2"));
						if (template != null) {
							template.addBlocksToWorldChunk(world, new BlockPos((int) (x + (-3)), (int) y, (int) (z + (-3))), new PlacementSettings()
									.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
						}
					}
				} else {
					if (!world.isRemote) {
						Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("aetheria", "silverwood1"));
						if (template != null) {
							template.addBlocksToWorldChunk(world, new BlockPos((int) (x + (-3)), (int) y, (int) (z + (-3))), new PlacementSettings()
									.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
						}
					}
				}
			}
		}
	}
}
