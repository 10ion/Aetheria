
package net.mcreator.aetheria.block;

@AetheriaElements.ModElement.Tag
public class LeadBlockBlock extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:leadblock")
	public static final Block block = null;

	public LeadBlockBlock(AetheriaElements instance) {
		super(instance, 149);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaToolsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(1.2f, 12f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("leadblock");
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.IGNORE;
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
