
package net.mcreator.aetheria.world.biome;

@AetheriaModElements.ModElement.Tag
public class UnderworldBiome2Biome extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:underworld_biome_2")
	public static final CustomBiome biome = null;

	public UnderworldBiome2Biome(AetheriaModElements instance) {
		super(instance, 512);
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
			super(new Biome.Builder().downfall(0f).depth(0f).scale(0.7f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(-10066330).waterFogColor(-10066330)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BedrockBlock.block.getDefaultState(),
							Blocks.BEDROCK.getDefaultState(), Blocks.BEDROCK.getDefaultState())));

			setRegistryName("underworld_biome_2");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

			DefaultBiomeFeatures.addLakes(this);

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
