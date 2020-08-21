
package net.mod.aetheria.block;

import net.mod.aetheria.itemgroup.AetheriaBlocksItemGroup;
import net.mod.aetheria.item.SapphireGemItem;
import net.mod.aetheria.AetheriaModElements;

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

import java.util.List;
import java.util.Collections;

@AetheriaModElements.ModElement.Tag
public class SapphireOreBlock extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:sapphire_ore")
	public static final Block block = null;
	public SapphireOreBlock(AetheriaModElements instance) {
		super(instance, 141);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4.5f, 6.915809336112958f).lightValue(0)
					.harvestLevel(3).harvestTool(ToolType.PICKAXE));
			setRegistryName("sapphire_ore");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(SapphireGemItem.block, (int) (1)));
		}
	}
}
