
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class SilverwoodFenceGateBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:silverwood_fence_gate")
	public static final Block block = null;

	public SilverwoodFenceGateBlock(AetheriaModElements instance) {
		super(instance, 758);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends FenceGateBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 3f).lightValue(0));

			setRegistryName("silverwood_fence_gate");
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
