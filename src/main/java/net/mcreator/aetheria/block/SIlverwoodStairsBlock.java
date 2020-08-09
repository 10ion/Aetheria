
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class SIlverwoodStairsBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:s_ilverwood_stairs")
	public static final Block block = null;

	public SIlverwoodStairsBlock(AetheriaModElements instance) {
		super(instance, 761);

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

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 3f).lightValue(0));

			setRegistryName("s_ilverwood_stairs");
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