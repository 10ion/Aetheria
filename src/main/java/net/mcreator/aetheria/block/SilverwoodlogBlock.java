
package net.mcreator.aetheria.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.aetheria.itemgroup.AetheriaBlocksItemGroup;
import net.mcreator.aetheria.AetheriaElements;

import java.util.List;
import java.util.Collections;

@AetheriaElements.ModElement.Tag
public class SilverwoodlogBlock extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:silverwoodlog")
	public static final Block block = null;
	public SilverwoodlogBlock(AetheriaElements instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.GROUND).hardnessAndResistance(-1f, 10f).lightValue(0).harvestLevel(-1)
					.harvestTool(ToolType.AXE));
			setRegistryName("silverwoodlog");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
