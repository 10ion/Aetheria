
package net.aetheria.mod.block;

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

import net.aetheria.mod.itemgroup.AetheriaBlocksItemGroup;
import net.aetheria.mod.AetheriaModElements;

import java.util.List;
import java.util.Collections;

@AetheriaModElements.ModElement.Tag
public class MysticalPlanksBlock extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:mysticalplanks")
	public static final Block block = null;
	public MysticalPlanksBlock(AetheriaModElements instance) {
		super(instance, 120);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3f, 16f).lightValue(15).harvestLevel(-1)
					.harvestTool(ToolType.AXE));
			setRegistryName("mysticalplanks");
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
