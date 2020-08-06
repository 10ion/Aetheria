
package net.mcreator.aetheria.block;

import net.minecraft.block.material.Material;

@AetheriaModElements.ModElement.Tag
public class SilverwoodDoorBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:silverwood_door")
	public static final Block block = null;

	public SilverwoodDoorBlock(AetheriaModElements instance) {
		super(instance, 759);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends DoorBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 3f).lightValue(0));

			setRegistryName("silverwood_door");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			if (state.get(BlockStateProperties.DOUBLE_BLOCK_HALF) != DoubleBlockHalf.LOWER)
				return Collections.emptyList();

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
