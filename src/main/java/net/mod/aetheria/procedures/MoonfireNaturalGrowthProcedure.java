package net.mod.aetheria.procedures;

import net.mod.aetheria.AetheriaModElements;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class MoonfireNaturalGrowthProcedure extends AetheriaModElements.ModElement {
	public MoonfireNaturalGrowthProcedure(AetheriaModElements instance) {
		super(instance, 626);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MoonfireNaturalGrowth!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MoonfireNaturalGrowth!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MoonfireNaturalGrowth!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MoonfireNaturalGrowth!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.005)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			if ((Math.random() < 0.33)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("aetheria", "moonfiretree4"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x + (-6)), (int) (y + (-2)), (int) (z + (-6))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
			} else {
				if ((Math.random() < 0.25)) {
					if (!world.getWorld().isRemote) {
						Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("aetheria", "moonfiretree1"));
						if (template != null) {
							template.addBlocksToWorld(world, new BlockPos((int) (x + (-6)), (int) (y + (-2)), (int) (z + (-7))),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
											.setIgnoreEntities(false));
						}
					}
				} else {
					if ((Math.random() < 0.25)) {
						if (!world.getWorld().isRemote) {
							Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("aetheria", "moonfiretree3"));
							if (template != null) {
								template.addBlocksToWorld(world, new BlockPos((int) (x + (-8)), (int) (y + (-2)), (int) (z + (-8))),
										new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
												.setIgnoreEntities(false));
							}
						}
					} else {
						if (!world.getWorld().isRemote) {
							Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("aetheria", "moonfiretree2"));
							if (template != null) {
								template.addBlocksToWorld(world, new BlockPos((int) (x + (-7)), (int) (y + (-2)), (int) (z + (-7))),
										new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
												.setIgnoreEntities(false));
							}
						}
					}
				}
			}
		}
	}
}
