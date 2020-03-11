// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class foxtail extends ModelBase {
	private final ModelRenderer tail;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer tail3;
	private final ModelRenderer ears;
	private final ModelRenderer rightear;
	private final ModelRenderer leftear;

	public foxtail() {
		textureWidth = 32;
		textureHeight = 32;

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 11.0F, 2.0F);
		setRotationAngle(tail, -0.8727F, 0.0F, 0.0F);

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, 0.0F, -1.0F);
		tail.addChild(tail1);
		tail1.cubeList.add(new ModelBox(tail1, 0, 0, -1.25F, 0.75F, 0.5F, 2, 2, 7, 0.0F, false));

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 2.0F, 3.0F);
		tail.addChild(tail2);
		tail2.cubeList.add(new ModelBox(tail2, 11, 0, -1.5F, -1.0F, 0.0F, 2, 2, 3, 0.0F, false));

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, 2.0F, 6.0F);
		tail.addChild(tail3);
		tail3.cubeList.add(new ModelBox(tail3, 0, 9, -1.6F, -1.9F, 0.0F, 3, 3, 4, 0.0F, false));

		ears = new ModelRenderer(this);
		ears.setRotationPoint(0.0F, 24.0F, 0.0F);

		rightear = new ModelRenderer(this);
		rightear.setRotationPoint(4.0F, -3.0F, -1.0F);
		setRotationAngle(rightear, 0.6109F, 0.5236F, 0.0F);
		rightear.cubeList.add(new ModelBox(rightear, 11, 13, -1.0F, -1.0F, 0.0F, 1, 2, 3, 0.0F, false));
		rightear.cubeList.add(new ModelBox(rightear, 0, 4, -1.0F, -0.5F, 3.0F, 1, 1, 1, 0.0F, false));
		rightear.cubeList.add(new ModelBox(rightear, 0, 0, -1.25F, -1.0F, 0.0F, 1, 2, 2, 0.0F, false));

		leftear = new ModelRenderer(this);
		leftear.setRotationPoint(-3.0F, -3.0F, -1.0F);
		setRotationAngle(leftear, 0.6109F, -0.5236F, 0.0F);
		leftear.cubeList.add(new ModelBox(leftear, 11, 13, -1.1F, -1.0F, 0.0F, 1, 2, 3, 0.0F, false));
		leftear.cubeList.add(new ModelBox(leftear, 0, 4, -1.1F, -0.5F, 3.0F, 1, 1, 1, 0.0F, false));
		leftear.cubeList.add(new ModelBox(leftear, 0, 0, -0.75F, -1.0F, 0.0F, 1, 2, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		tail.render(f5);
		ears.render(f5);
		rightear.render(f5);
		leftear.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}