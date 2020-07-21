
package net.mcreator.aetheria.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.PlantType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.potion.Effects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.aetheria.procedures.SilverwoodgrowthbonemealProcedure;
import net.mcreator.aetheria.procedures.SilverwoodalsonaturalgrowthProcedure;
import net.mcreator.aetheria.itemgroup.AetheriaMiscItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@AetheriaModElements.ModElement.Tag
public class SilverwoodsapBlock extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:silverwoodsap")
	public static final Block block = null;
	public SilverwoodsapBlock(AetheriaModElements instance) {
		super(instance, 155);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaMiscItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class BlockCustomFlower extends FlowerBlock {
		public BlockCustomFlower() {
			super(Effects.SATURATION, 0, Block.Properties.create(Material.PLANTS, MaterialColor.FOLIAGE).doesNotBlockMovement().sound(SoundType.PLANT)
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
			return PlantType.Plains;
		}

		@Override
		public void tick(BlockState state, World world, BlockPos pos, Random random) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SilverwoodalsonaturalgrowthProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult hit) {
			boolean retval = super.onBlockActivated(state, world, pos, entity, hand, hit);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Direction direction = hit.getFace();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SilverwoodgrowthbonemealProcedure.executeProcedure($_dependencies);
			}
			return true;
		}
	}
}
