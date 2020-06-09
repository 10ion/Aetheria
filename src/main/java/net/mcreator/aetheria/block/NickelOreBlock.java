
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class NickelOreBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:nickelore")
	public static final Block block = null;

	public NickelOreBlock(AetheriaModElements instance) {
		super(instance, 457);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.25f, 10f).lightValue(0));

			setRegistryName("nickelore");
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