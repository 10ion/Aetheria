
package net.mcreator.aetheria.world.biome;

@AetheriaModElements.ModElement.Tag
public class SoullessPlainsBiome extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:soulless_plains")
	public static final CustomBiome biome = null;

	public SoullessPlainsBiome(AetheriaModElements instance) {
		super(instance, 515);
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
			super(new Biome.Builder().downfall(0f).depth(0f).scale(0f).temperature(0f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(-13434880).waterFogColor(-13434880)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.SOUL_SAND.getDefaultState(),
							Blocks.SOUL_SAND.getDefaultState(), Blocks.SOUL_SAND.getDefaultState())));

			setRegistryName("soulless_plains");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);

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
			return -13434880;
		}

	}

}
