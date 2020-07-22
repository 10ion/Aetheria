
package net.mcreator.aetheria.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;

import net.mcreator.aetheria.block.BedrockBlock;
import net.mcreator.aetheria.AetheriaModElements;

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
