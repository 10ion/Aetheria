
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class BlueCrocoiteBlockBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:crocoite_block")
	public static final Block block = null;

	public BlueCrocoiteBlockBlock(AetheriaModElements instance) {
		super(instance, 116);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3f, 16f).lightValue(0));

			setRegistryName("crocoite_block");
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public BlockRenderLayer getRenderLayer() {
			return BlockRenderLayer.TRANSLUCENT;
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.LIGHT_BLUE;
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
