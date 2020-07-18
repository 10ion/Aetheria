
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class BedrockBreakerItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:bedrock_breaker")
	public static final Item block = null;

	public BedrockBreakerItem(AetheriaModElements instance) {
		super(instance, 499);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 124;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 2.5f;
			}

			public int getHarvestLevel() {
				return 7;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}

		}.setRegistryName("bedrock_breaker"));
	}

}
