
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class SilverArmorItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:silver_armorhelmet")
	public static final Item helmet = null;

	@ObjectHolder("aetheria:silver_armorbody")
	public static final Item body = null;

	@ObjectHolder("aetheria:silver_armorlegs")
	public static final Item legs = null;

	@ObjectHolder("aetheria:silver_armorboots")
	public static final Item boots = null;

	public SilverArmorItem(AetheriaModElements instance) {
		super(instance, 673);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 10;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{1, 4, 4, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 23;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SilverIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "silver_armor";
			}

			public float getToughness() {
				return 0.2f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/silver_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("silver_armorhelmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/silver_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("silver_armorbody"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/silver_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("silver_armorlegs"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/silver_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("silver_armorboots"));
	}

}
