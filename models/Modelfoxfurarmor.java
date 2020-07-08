// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class Modelfoxfurarmor extends EntityModel {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer tail;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightBoot;
	private final ModelRenderer LeftBoot;

	public Modelfoxfurarmor() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -1.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -7.25F, -4.0F, 8, 8, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 42, 9, -1.5F, -6.5F, -7.0F, 3, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 3, 1.5F, -10.5F, -2.0F, 2, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 0, -3.5F, -10.5F, -2.0F, 2, 2, 1, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 12.0937F, -0.4226F);
		Body.addChild(tail);
		setRotationAngle(tail, -1.1345F, 0.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 14, 22, -1.5F, -3.0937F, 0.5774F, 3, 3, 10, 0.0F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		Body.addChild(LeftArm);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 16, 35, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-2.0F, 2.0F, 0.0F);
		Body.addChild(RightArm);
		RightArm.cubeList.add(new ModelBox(RightArm, 32, 35, -6.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 32, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 30, 12, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		RightBoot = new ModelRenderer(this);
		RightBoot.setRotationPoint(0.0F, 12.0F, 0.0F);
		RightBoot.cubeList.add(new ModelBox(RightBoot, 32, 0, -3.9F, 7.0F, -2.0F, 4, 5, 4, 0.0F, false));

		LeftBoot = new ModelRenderer(this);
		LeftBoot.setRotationPoint(0.0F, 12.0F, 0.0F);
		LeftBoot.cubeList.add(new ModelBox(LeftBoot, 42, 24, -0.1F, 7.0F, -2.0F, 4, 5, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Head.render(f5);
		Body.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
		RightBoot.render(f5);
		LeftBoot.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.tail.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftBoot.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.RightBoot.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}