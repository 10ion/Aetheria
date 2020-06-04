package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class SilverwoodgrowthbonemealProcedure extends AetheriaModElements.ModElement {

	public SilverwoodgrowthbonemealProcedure(AetheriaModElements instance) {
		super(instance, 244);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Silverwoodgrowthbonemeal!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Silverwoodgrowthbonemeal!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Silverwoodgrowthbonemeal!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Silverwoodgrowthbonemeal!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Silverwoodgrowthbonemeal!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.BONE_MEAL, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.BONE_MEAL, (int) (1)).getItem()))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(Items.BONE_MEAL, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.COMPOSTER, x, (y + 1), z, (int) 5, 3, 3, 3, 1);
			}
		}
		if ((Math.random() < 0.2)) {
			if ((Math.random() < 0.25)) {
				if (!world.isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("aetheria", "silverwood1"));
					if (template != null) {
						template.addBlocksToWorldChunk(world, new BlockPos((int) (x + (-3)), (int) y, (int) (z + (-3))), new PlacementSettings()
								.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
					}
				}
			} else {
				if ((Math.random() < 0.25)) {
					if (!world.isRemote) {
						Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("aetheria", "silverwood2"));
						if (template != null) {
							template.addBlocksToWorldChunk(world, new BlockPos((int) (x + (-3)), (int) y, (int) (z + (-3))), new PlacementSettings()
									.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
						}
					}
				} else {
					if ((Math.random() < 0.25)) {
						if (!world.isRemote) {
							Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("aetheria", "silverwood3"));
							if (template != null) {
								template.addBlocksToWorldChunk(world, new BlockPos((int) (x + (-3)), (int) y, (int) (z + (-3))),
										new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null)
												.setIgnoreEntities(false));
							}
						}
					} else {
						if (!world.isRemote) {
							Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("aetheria", "silverwood4"));
							if (template != null) {
								template.addBlocksToWorldChunk(world, new BlockPos((int) (x + (-3)), (int) y, (int) (z + (-3))),
										new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null)
												.setIgnoreEntities(false));
							}
						}
					}
				}
			}
		}

	}

}
