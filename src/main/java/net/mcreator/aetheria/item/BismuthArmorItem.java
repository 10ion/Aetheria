
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class BismuthArmorItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:bismuth_armorhelmet")
	public static final Item helmet = null;

	@ObjectHolder("aetheria:bismuth_armorbody")
	public static final Item body = null;

	@ObjectHolder("aetheria:bismuth_armorlegs")
	public static final Item legs = null;

	@ObjectHolder("aetheria:bismuth_armorboots")
	public static final Item boots = null;

	public BismuthArmorItem(AetheriaModElements instance) {
		super(instance, 703);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 23;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{3, 6, 6, 3}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BismuthIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "bismuth_armor";
			}

			public float getToughness() {
				return 0f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/bismuth_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("bismuth_armorhelmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/bismuth_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("bismuth_armorbody"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/bismuth_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("bismuth_armorlegs"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/bismuth_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("bismuth_armorboots"));
	}

}
