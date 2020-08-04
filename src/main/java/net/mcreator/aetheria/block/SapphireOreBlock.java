
package net.mcreator.aetheria.block;

import net.minecraft.block.material.Material;

@AetheriaModElements.ModElement.Tag
public class SapphireOreBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:sapphire_ore")
	public static final Block block = null;

	public SapphireOreBlock(AetheriaModElements instance) {
		super(instance, 731);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4.5f, 6.915809336112958f).lightValue(0)
							.harvestLevel(3).harvestTool(ToolType.PICKAXE));

			setRegistryName("sapphire_ore");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(SapphireGemItem.block, (int) (1)));
		}

	}

}
