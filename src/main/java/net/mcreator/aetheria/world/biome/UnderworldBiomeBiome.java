
package net.mcreator.aetheria.world.biome;

@AetheriaModElements.ModElement.Tag
public class UnderworldBiomeBiome extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:underworld_biome")
	public static final CustomBiome biome = null;

	public UnderworldBiomeBiome(AetheriaModElements instance) {
		super(instance, 491);
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
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(-16737895).waterFogColor(-16737895)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.BEDROCK.getDefaultState(),
							Blocks.BEDROCK.getDefaultState(), Blocks.BEDROCK.getDefaultState())));

			setRegistryName("underworld_biome");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(BlockPos pos) {
			return -16764160;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor(BlockPos pos) {
			return -16764160;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -13421773;
		}

	}

}
