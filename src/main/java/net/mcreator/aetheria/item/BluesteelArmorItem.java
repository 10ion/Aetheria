
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class BluesteelArmorItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:bluesteel_armorhelmet")
	public static final Item helmet = null;

	@ObjectHolder("aetheria:bluesteel_armorbody")
	public static final Item body = null;

	@ObjectHolder("aetheria:bluesteel_armorlegs")
	public static final Item legs = null;

	@ObjectHolder("aetheria:bluesteel_armorboots")
	public static final Item boots = null;

	public BluesteelArmorItem(AetheriaModElements instance) {
		super(instance, 570);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 55;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{5, 9, 10, 5}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 32;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BlueSteelIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "bluesteel_armor";
			}

			public float getToughness() {
				return 4f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/bluesteel_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("bluesteel_armorhelmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/bluesteel_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("bluesteel_armorbody"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/bluesteel_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("bluesteel_armorlegs"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/bluesteel_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("bluesteel_armorboots"));
	}

}
