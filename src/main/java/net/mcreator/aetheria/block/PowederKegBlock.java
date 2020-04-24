
package net.mcreator.aetheria.block;

@AetheriaElements.ModElement.Tag
public class PowederKegBlock extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:powederkeg")
	public static final Block block = null;

	public PowederKegBlock(AetheriaElements instance) {
		super(instance, 154);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaMiscItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 2f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.AXE));

			setRegistryName("powederkeg");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
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
