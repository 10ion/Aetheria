// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class blockbird extends EntityModel<Entity> {
	private final ModelRenderer blockbird;
	private final ModelRenderer bone;
	private final ModelRenderer rightwing;
	private final ModelRenderer leftwing;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;

	public blockbird() {
		textureWidth = 32;
		textureHeight = 32;

		blockbird = new ModelRenderer(this);
		blockbird.setRotationPoint(0.0F, 24.0F, 7.0F);
		blockbird.setTextureOffset(0, 2).addBox(-0.5F, -7.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		blockbird.setTextureOffset(0, 0).addBox(-3.5F, -9.0F, -10.0F, 7.0F, 6.0F, 7.0F, 0.0F, false);
		blockbird.setTextureOffset(0, 13).addBox(-3.5F, -10.0F, -10.0F, 7.0F, 1.0F, 5.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -10.0F, -9.0F);
		blockbird.addChild(bone);
		setRotationAngle(bone, 0.9599F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-1.1056F, -0.7149F, -0.5F, 2.0F, 0.0F, 2.0F, 0.0F, false);

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(-3.5F, -7.0F, -6.0F);
		blockbird.addChild(rightwing);
		rightwing.setTextureOffset(0, 19).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(3.5F, -7.0F, -6.0F);
		blockbird.addChild(leftwing);
		leftwing.setTextureOffset(0, 19).addBox(0.0F, 0.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(2.0F, -3.0F, -6.0F);
		blockbird.addChild(rightleg);
		rightleg.setTextureOffset(0, 4).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		rightleg.setTextureOffset(2, 2).addBox(-0.5F, 3.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-2.0F, -3.0F, -6.0F);
		blockbird.addChild(leftleg);
		leftleg.setTextureOffset(2, 4).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		leftleg.setTextureOffset(3, 3).addBox(-0.5F, 3.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		blockbird.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.blockbird.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.blockbird.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightwing.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftwing.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
	}
}