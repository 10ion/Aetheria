
package net.mcreator.aetheria.block;

import net.minecraft.block.material.Material;

@AetheriaModElements.ModElement.Tag
public class MoonfireLeaveBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:moonfire_leave")
	public static final Block block = null;

	public MoonfireLeaveBlock(AetheriaModElements instance) {
		super(instance, 105);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends LeavesBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0f, 0f).lightValue(0).notSolid());

			setRegistryName("moonfire_leave");
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.GREEN;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(MoonfireSaplingItem.block, (int) (0)));
		}

	}

}
