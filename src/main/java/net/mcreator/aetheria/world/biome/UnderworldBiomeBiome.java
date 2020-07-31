
package net.mcreator.aetheria.world.biome;

@AetheriaModElements.ModElement.Tag
public class UnderworldBiomeBiome extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:underworld_biome")
	public static final CustomBiome biome = null;

	public UnderworldBiomeBiome(AetheriaModElements instance) {
		super(instance, 516);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0f).scale(0.2f).temperature(0f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(-16777165).waterFogColor(-16777165)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BedrockBlock.block.getDefaultState(),
							BedrockBlock.block.getDefaultState(), BedrockBlock.block.getDefaultState())));

			setRegistryName("underworld_biome");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

			DefaultBiomeFeatures.addLakes(this);

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH,
					new BushConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(10)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH,
					new BushConfig(Blocks.RED_MUSHROOM.getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(10)));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Biome.createDecoratedFeature(
							Feature.RANDOM_BOOLEAN_SELECTOR, new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM,
									new BigMushroomFeatureConfig(false), Feature.HUGE_BROWN_MUSHROOM, new BigMushroomFeatureConfig(false)),
							Placement.COUNT_HEIGHTMAP, new FrequencyConfig(8)));

		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(BlockPos pos) {
			return -13421773;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor(BlockPos pos) {
			return -13421773;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -13421773;
		}

	}

}
