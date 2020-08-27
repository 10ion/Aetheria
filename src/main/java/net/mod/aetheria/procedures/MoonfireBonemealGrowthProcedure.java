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
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class MoonfireBonemealGrowthProcedure extends AetheriaModElements.ModElement {
	public MoonfireBonemealGrowthProcedure(AetheriaModElements instance) {
		super(instance, 750);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MoonfireBonemealGrowth!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MoonfireBonemealGrowth!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MoonfireBonemealGrowth!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MoonfireBonemealGrowth!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MoonfireBonemealGrowth!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.BONE_MEAL, (int) (1)).getItem())) {
			if ((Math.random() < 0.33)) {
				if (!world.getWorld().isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("aetheria", "moonfiretree4"));
					if (template != null) {
						template.addBlocksToWorld(world, new BlockPos((int) (x + (-6)), (int) (y + (-2)), (int) (z + (-6))),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
					}
				}
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
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
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
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
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
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
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					}
				}
			}
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.COMPOSTER, x, y, z, (int) 5, 1, 1, 1, 2);
		}
	}
}
