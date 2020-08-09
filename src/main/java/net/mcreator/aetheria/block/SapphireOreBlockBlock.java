
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class SapphireOreBlockBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:sapphire_ore_block")
	public static final Block block = null;

	public SapphireOreBlockBlock(AetheriaModElements instance) {
		super(instance, 732);

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

					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5f, 10f).lightValue(0).harvestLevel(3)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("sapphire_ore_block");
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
