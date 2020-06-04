
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class ScytheItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:scythe")
	public static final Item block = null;

	public ScytheItem(AetheriaModElements instance) {
		super(instance, 453);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 7500;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.IRON_BLOCK, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(AetheriaWeaponsItemGroup.tab)) {

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);

					FastCommandExecutedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

		}.setRegistryName("scythe"));
	}

}
