
package net.mod.aetheria.block;

import net.mod.aetheria.itemgroup.AetheriaMiscItemGroup;
import net.mod.aetheria.item.ParasolMushroomItem;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@AetheriaModElements.ModElement.Tag
public class ParasolMushroomPatchBlock extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:parasol_mushroom_patch")
	public static final Block block = null;
	public ParasolMushroomPatchBlock(AetheriaModElements instance) {
		super(instance, 112);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaMiscItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class BlockCustomFlower extends FlowerBlock {
		public BlockCustomFlower() {
			super(Effects.SATURATION, 0, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT)
					.hardnessAndResistance(0f, 0f).lightValue(0));
			setRegistryName("parasol_mushroom_patch");
		}

		@Override
		public Block.OffsetType getOffsetType() {
			return Block.OffsetType.NONE;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(ParasolMushroomItem.block, (int) (3)));
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.Cave;
		}
	}
}
