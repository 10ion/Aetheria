package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.Blocks;

@Elementsaetheria.ModElement.Tag
public class MCreatorExtremevoidplanes extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:extremevoidplanes")
	public static final CustomBiome biome = null;

	public MCreatorExtremevoidplanes(Elementsaetheria instance) {
		super(instance, 292);
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
			super(new Biome.Builder()
					.downfall(0f)
					.depth(0.1f)
					.scale(0.5700000000000001f)
					.temperature(0.46f)
					.precipitation(Biome.RainType.NONE)
					.category(Biome.Category.EXTREME_HILLS)
					.waterColor(4159204)
					.waterFogColor(329011)
					.parent("aetheria:voidplanes")
					.surfaceBuilder(
							SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.MYCELIUM.getDefaultState(), MCreatorVoidStone.block.getDefaultState(),
									MCreatorVoidStone.block.getDefaultState())));
			setRegistryName("extremevoidplanes");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
		}
	}
}
