package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

@Elementsaetheria.ModElement.Tag
public class MCreatorVoidplanes extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:voidplanes")
	public static final CustomBiome biome = null;

	public MCreatorVoidplanes(Elementsaetheria instance) {
		super(instance, 141);
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
					.scale(0.22f)
					.temperature(0.3f)
					.precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE)
					.waterColor(4159204)
					.waterFogColor(329011)
					.surfaceBuilder(
							SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(MCreatorVoidMycelium.block.getDefaultState(), MCreatorVoidStone.block.getDefaultState(),
									MCreatorVoidStone.block.getDefaultState())));
			setRegistryName("voidplanes");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH,
					new BushConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(160)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH,
					new BushConfig(Blocks.RED_MUSHROOM.getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(160)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_BOOLEAN_SELECTOR,
					new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM, new BigMushroomFeatureConfig(false), Feature.HUGE_BROWN_MUSHROOM,
							new BigMushroomFeatureConfig(false)), Placement.COUNT_HEIGHTMAP, new FrequencyConfig(4)));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.MOOSHROOM, 15, 1, 5));
		}
	}
}
