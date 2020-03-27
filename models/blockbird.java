// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class blockbird extends ModelBase {
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
		blockbird.cubeList.add(new ModelBox(blockbird, 0, 2, -0.5F, -7.0F, -11.0F, 1, 1, 1, 0.0F, false));
		blockbird.cubeList.add(new ModelBox(blockbird, 0, 0, -3.5F, -9.0F, -10.0F, 7, 6, 7, 0.0F, false));
		blockbird.cubeList.add(new ModelBox(blockbird, 0, 13, -3.5F, -10.0F, -10.0F, 7, 1, 5, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -10.0F, -9.0F);
		setRotationAngle(bone, 0.9599F, 0.0F, 0.0F);
		blockbird.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.1056F, -0.7149F, -0.5F, 2, 0, 2, 0.0F, false));

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(-3.5F, -7.0F, -6.0F);
		blockbird.addChild(rightwing);
		rightwing.cubeList.add(new ModelBox(rightwing, 0, 19, -1.0F, 0.0F, -2.0F, 1, 3, 4, 0.0F, false));

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(3.5F, -7.0F, -6.0F);
		blockbird.addChild(leftwing);
		leftwing.cubeList.add(new ModelBox(leftwing, 0, 19, 0.0F, 0.0F, -2.0F, 1, 3, 4, 0.0F, false));

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(2.0F, -3.0F, -6.0F);
		blockbird.addChild(rightleg);
		rightleg.cubeList.add(new ModelBox(rightleg, 0, 4, -0.5F, 0.0F, 0.0F, 1, 3, 0, 0.0F, false));
		rightleg.cubeList.add(new ModelBox(rightleg, 2, 2, -0.5F, 3.0F, -1.0F, 1, 0, 1, 0.0F, false));

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-2.0F, -3.0F, -6.0F);
		blockbird.addChild(leftleg);
		leftleg.cubeList.add(new ModelBox(leftleg, 2, 4, -0.5F, 0.0F, 0.0F, 1, 3, 0, 0.0F, false));
		leftleg.cubeList.add(new ModelBox(leftleg, 3, 3, -0.5F, 3.0F, -1.0F, 1, 0, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		blockbird.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}