// Made with Blockbench 3.5.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelzombie extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public Modelzombie() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(28, 28).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.5F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(rightArm, -1.3963F, 0.0F, 0.0F);
		rightArm.setTextureOffset(56, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightArm.setTextureOffset(32, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, false);
		rightArm.setTextureOffset(16, 32).addBox(-3.0F, 10.0F, 1.0F, 4.0F, 0.0F, 4.0F, 0.0F, false);
		rightArm.setTextureOffset(28, 24).addBox(-3.0F, 8.0304F, 1.3473F, 4.0F, 0.0F, 4.0F, 0.0F, false);
		rightArm.setTextureOffset(28, 20).addBox(-3.0F, 5.8871F, 0.7098F, 4.0F, 0.0F, 4.0F, 0.0F, false);
		rightArm.setTextureOffset(28, 16).addBox(-3.0F, 3.9175F, 1.0571F, 4.0F, 0.0F, 4.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(leftArm, -1.3963F, 0.0F, 0.0F);
		leftArm.setTextureOffset(52, 28).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		leftArm.setTextureOffset(20, 44).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, false);
		leftArm.setTextureOffset(20, 16).addBox(-1.0F, 3.9175F, 1.0571F, 4.0F, 0.0F, 4.0F, 0.0F, false);
		leftArm.setTextureOffset(20, 4).addBox(-1.0F, 10.0F, 1.0F, 4.0F, 0.0F, 4.0F, 0.0F, false);
		leftArm.setTextureOffset(20, 0).addBox(-1.0F, 8.0304F, 1.3473F, 4.0F, 0.0F, 4.0F, 0.0F, false);
		leftArm.setTextureOffset(20, 20).addBox(-1.0F, 5.8871F, 0.7098F, 4.0F, 0.0F, 4.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		rightLeg.setTextureOffset(52, 52).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		rightLeg.setTextureOffset(44, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		leftLeg.setTextureOffset(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		leftLeg.setTextureOffset(36, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}