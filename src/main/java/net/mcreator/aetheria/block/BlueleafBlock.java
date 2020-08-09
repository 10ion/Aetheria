
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class BlueleafBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:blueleaf")
	public static final Block block = null;

	public BlueleafBlock(AetheriaModElements instance) {
		super(instance, 117);

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

					Block.Properties.create(Material.LEAVES).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("blueleaf");
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
