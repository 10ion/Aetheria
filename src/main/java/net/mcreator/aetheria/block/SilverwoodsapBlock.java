
package net.mcreator.aetheria.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.PlantType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.aetheria.itemgroup.AetheriaMiscItemGroup;
import net.mcreator.aetheria.AetheriaElements;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@AetheriaElements.ModElement.Tag
public class SilverwoodsapBlock extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:silverwoodsap")
	public static final Block block = null;
	public SilverwoodsapBlock(AetheriaElements instance) {
		super(instance, 155);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaMiscItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class BlockCustomFlower extends SugarCaneBlock {
		public BlockCustomFlower() {
			super(Block.Properties.create(Material.PLANTS, MaterialColor.FOLIAGE).tickRandomly().doesNotBlockMovement().sound(SoundType.PLANT)
					.hardnessAndResistance(0f, 0f).lightValue(0));
			setRegistryName("silverwoodsap");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.Crop;
		}

		@Override
		public void tick(BlockState state, World world, BlockPos pos, Random random) {
			if (!state.isValidPosition(world, pos)) {
				world.destroyBlock(pos, true);
			} else if (world.isAirBlock(pos.up())) {
				int i = 1;
				for (; world.getBlockState(pos.down(i)).getBlock() == this; ++i);
				if (i < 1) {
					int j = state.get(AGE);
					if (j == 15) {
						world.setBlockState(pos.up(), getDefaultState());
						world.setBlockState(pos, state.with(AGE, 0), 4);
					} else {
						world.setBlockState(pos, state.with(AGE, j + 1), 4);
					}
				}
			}
		}
	}
}
