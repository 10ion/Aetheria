// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class Modeldeadbody extends EntityModel {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public Modeldeadbody() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Head, -1.6755F, 0.0873F, 0.3491F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, 2.8144F, -11.5519F, 14.5241F, 8, 8, 8, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 3.0F);
		setRotationAngle(Body, -1.3963F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 16, 16, -4.0F, 3.9176F, 16.3526F, 8, 12, 4, 0.0F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-9.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, 0.0F, 2.7053F, 1.3963F);
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 16, -18.7937F, -2.8192F, 5.3647F, 4, 12, 4, 0.0F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, 0.2094F, 0.0F, -1.4835F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 32, 48, -20.1047F, 0.2661F, -2.4817F, 4, 12, 4, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 1.0F, -10.0F);
		setRotationAngle(RightLeg, 1.501F, -2.7925F, 0.0349F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 16, -2.6231F, 0.1571F, -21.9264F, 4, 12, 4, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -1.5708F, -0.5236F, -0.2094F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 16, 48, -7.7456F, 7.1316F, 7.9894F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Head.render(f5);
		Body.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}