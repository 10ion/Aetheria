
package net.mcreator.aetheria.block;

@AetheriaModElements.ModElement.Tag
public class SilverwoodTrapDoorBlock extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:silverwood_trap_door")
	public static final Block block = null;

	public SilverwoodTrapDoorBlock(AetheriaModElements instance) {
		super(instance, 760);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(AetheriaBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends TrapDoorBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 3f).lightValue(0));

			setRegistryName("silverwood_trap_door");
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
