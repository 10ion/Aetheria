
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class GlowshroomBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:glowshroom")
	public static final Block block = null;

	public GlowshroomBlock(AetheriaModElements instance) {
		super(instance, 471);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(block.getRegistryName()));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		FlowersFeature feature = new FlowersFeature(NoFeatureConfig::deserialize) {
			@Override
			public BlockState getRandomFlower(Random random, BlockPos pos) {
				return block.getDefaultState();
			}

			@Override
			public boolean place(IWorld world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
				DimensionType dimensionType = world.getDimension().getType();
				boolean dimensionCriteria = false;

				if (dimensionType == TheAetherDimension.type)
					dimensionCriteria = true;

				if (!dimensionCriteria)
					return false;

				return super.place(world, generator, random, pos, config);
			}
		};

		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Biome.createDecoratedFeature(feature, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(3)));
		}
	}

	public static class BlockCustomFlower extends FlowerBlock {

		public BlockCustomFlower() {
			super(Effects.SATURATION, 0, Block.Properties.create(Material.PLANTS, MaterialColor.YELLOW).doesNotBlockMovement().sound(SoundType.PLANT)
					.hardnessAndResistance(0f, 0f).lightValue(0));
			setRegistryName("glowshroom");
		}

		@Override
		public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
			return new ItemStack(GlowshroomItemItem.block, (int) (1));
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(GlowshroomItemItem.block, (int) (1)));
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.Nether;
		}

	}
}
