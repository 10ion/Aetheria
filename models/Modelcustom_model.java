// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel {
	private final ModelRenderer bone;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.5F, -8.5F, -4.5F, 9, 0, 9, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 15, 4.5F, -8.5F, -4.5F, 0, 2, 9, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 23, 12, -4.5F, -8.5F, -4.5F, 9, 2, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 20, 9, -5.5F, -6.5F, -7.5F, 11, 0, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 19, -5.5F, -6.5F, 4.5F, 12, 0, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 9, -7.5F, -6.5F, -5.5F, 3, 0, 11, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 7, 9, 4.5F, -6.5F, -5.5F, 3, 0, 10, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 18, 22, -4.5F, -8.5F, 4.5F, 9, 2, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 13, -4.5F, -8.5F, -4.5F, 0, 2, 9, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}