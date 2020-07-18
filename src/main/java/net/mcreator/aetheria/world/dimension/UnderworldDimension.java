
package net.mcreator.aetheria.world.dimension;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Supplier;

@AetheriaModElements.ModElement.Tag
public class UnderworldDimension extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:underworld")
	public static final ModDimension dimension = null;

	public static DimensionType type = null;

	private static Biome[] dimensionBiomes;

	public UnderworldDimension(AetheriaModElements instance) {
		super(instance, 490);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerDimension(RegistryEvent.Register<ModDimension> event) {
		event.getRegistry().register(new CustomModDimension().setRegistryName("underworld"));
	}

	@SubscribeEvent
	public void onRegisterDimensionsEvent(RegisterDimensionsEvent event) {
		if (DimensionType.byName(new ResourceLocation("aetheria:underworld")) == null) {
			DimensionManager.registerDimension(new ResourceLocation("aetheria:underworld"), dimension, null, true);
		}

		type = DimensionType.byName(new ResourceLocation("aetheria:underworld"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		dimensionBiomes = new Biome[]{};
	}

	public static class CustomModDimension extends ModDimension {

		@Override
		public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
			return CustomDimension::new;
		}

	}

	public static class CustomDimension extends Dimension {

		private BiomeProviderCustom biomeProviderCustom = null;

		public CustomDimension(World world, DimensionType type) {
			super(world, type);
			this.nether = true;
		}

		@Override public void calculateInitialWeather() {
		}

    	@Override public void updateWeather(Runnable defaultWeather) {
		}

		@Override public boolean canDoLightning(Chunk chunk) {
			return false;
		}

		@Override public boolean canDoRainSnowIce(Chunk chunk) {
			return false;
		}

		@Override @OnlyIn(Dist.CLIENT) public Vec3d getFogColor(float cangle, float ticks) {
			return new Vec3d(0.4,0.4,0.4);
		}

		@Override public ChunkGenerator<?> createChunkGenerator() {
			if(this.biomeProviderCustom == null) {
				this.biomeProviderCustom = new BiomeProviderCustom(this.world);
			}
			return new ChunkProviderModded(this.world, this.biomeProviderCustom);
		}

		@Override public boolean isSurfaceWorld() {
			return false;
		}

		@Override public boolean canRespawnHere() {
			return false;
		}

		@OnlyIn(Dist.CLIENT) @Override public boolean doesXZShowFog(int x, int z) {
			return true;
		}

		@Override public SleepResult canSleepAt(PlayerEntity player, BlockPos pos){
        	return SleepResult.ALLOW;
		}

		@Nullable public BlockPos findSpawn(ChunkPos chunkPos, boolean checkValid) {
   		   return null;
   		}

   		@Nullable public BlockPos findSpawn(int x, int z, boolean checkValid) {
   		   return null;
   		}


		@Override public boolean doesWaterVaporize() {
      		return false;
   		}

		@Override /* failed to load code for net.minecraft.world.dimension.OverworldDimension */

	}

	public static class ChunkProviderModded extends NetherChunkGenerator {

		public ChunkProviderModded(World world, BiomeProvider provider) {
			super(world, provider, new NetherGenSettings() {
				public BlockState getDefaultBlock() {
					return Blocks.BEDROCK.getDefaultState();
				}

				public BlockState getDefaultFluid() {
					return Blocks.AIR.getDefaultState();
				}
			});
			this.randomSeed.skip(9716);
		}

		@Override
		public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
			return this.world.getBiome(pos).getSpawns(creatureType);
		}

	}

	public static class BiomeLayerCustom implements IC0Transformer {

		@Override
		public int apply(INoiseRandom context, int value) {
			return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
		}

	}

public static class BiomeProviderCustom extends BiomeProvider {

	private final Layer genBiomes;
	private final Layer biomeFactoryLayer;
	private final Biome[] biomes;

	public BiomeProviderCustom(World world) {
		Layer[] aLayer = makeTheWorld(world.getSeed());
		this.genBiomes = aLayer[0];
		this.biomeFactoryLayer = aLayer[1];
		this.biomes = dimensionBiomes;


	}

	private Layer[] makeTheWorld(long seed) {
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(25, seed, l);

		IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
		IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerCustom()).apply(contextFactory.apply(200), parentLayer);

		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);

		IAreaFactory<LazyArea> voronoizoom = VoroniZoomLayer.INSTANCE.apply(contextFactory.apply(10), biomeLayer);

		return new Layer[] { new Layer(biomeLayer), new Layer(voronoizoom) };
	}

	@Override /* failed to load code for net.minecraft.world.biome.provider.OverworldBiomeProvider */
	@Override /* failed to load code for net.minecraft.world.biome.provider.OverworldBiomeProvider */
	@Override /* failed to load code for net.minecraft.world.biome.provider.OverworldBiomeProvider */
	@Override /* failed to load code for net.minecraft.world.biome.provider.OverworldBiomeProvider */
	@Override /* failed to load code for net.minecraft.world.biome.provider.OverworldBiomeProvider */
	@Override /* failed to load code for net.minecraft.world.biome.provider.OverworldBiomeProvider */
	@Override /* failed to load code for net.minecraft.world.biome.provider.OverworldBiomeProvider */


}

}
