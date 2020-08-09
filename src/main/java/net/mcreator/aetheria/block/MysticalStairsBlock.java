
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class MysticalStairsBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:mystical_stairs")
	public static final Block block = null;

	public MysticalStairsBlock(AetheriaModElements instance) {
		super(instance, 733);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {

		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK)).getDefaultState(),

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("mystical_stairs");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 20;
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
