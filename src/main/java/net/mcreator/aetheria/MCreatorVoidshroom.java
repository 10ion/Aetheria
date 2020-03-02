package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@Elementsaetheria.ModElement.Tag
public class MCreatorVoidshroom extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:voidshroom")
	public static final Block block = null;

	public MCreatorVoidshroom(Elementsaetheria instance) {
		super(instance, 201);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0f, 0f).lightValue(0).doesNotBlockMovement());
			setRegistryName("voidshroom");
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public BlockRenderLayer getRenderLayer() {
			return BlockRenderLayer.CUTOUT_MIPPED;
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.CYAN;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			super.animateTick(state, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Block block = this;
			int i = x;
			int j = y;
			int k = z;
			if (true)
				for (int l = 0; l < 10; ++l) {
					double d0 = (i + 0.5) + (random.nextFloat() - 0.5) * 0.1999999985098839D;
					double d1 = ((j + 0.7) + (random.nextFloat() - 0.5) * 0.1999999985098839D * 100) + 0.5D;
					double d2 = (k + 0.5) + (random.nextFloat() - 0.5) * 0.1999999985098839D;
					world.addParticle(ParticleTypes.UNDERWATER, d0 - 0.27, d1 + 0.22, d2, 0, 0, 0);
				}
		}
	}
}
