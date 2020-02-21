//Made with Blockbench
//Paste this code into your mod.

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class custom_model extends ModelBase {
	private final ModelRenderer Tail;
	private final ModelRenderer Tail2;
	private final ModelRenderer ear;
	private final ModelRenderer ear2;

	public custom_model() {
		textureWidth = 32;
		textureHeight = 32;

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 12.0F, 2.0F);
		setRotationAngle(Tail, -1.309F, 0.0F, 0.0F);
		Tail.cubeList.add(new ModelBox(Tail, 0, 0, -0.5F, -2.0F, 0.0F, 1, 1, 10, 0.0F, false));

		Tail2 = new ModelRenderer(this);
		Tail2.setRotationPoint(0.0F, 17.0F, 4.0F);
		setRotationAngle(Tail2, 1.2217F, 0.0F, 0.0F);
		Tail2.cubeList.add(new ModelBox(Tail2, 0, 11, -0.5F, 3.0F, -3.0F, 1, 1, 5, 0.0F, false));

		ear = new ModelRenderer(this);
		ear.setRotationPoint(-3.0F, -9.0F, -2.0F);
		setRotationAngle(ear, -1.5708F, 0.0F, 0.0F);
		ear.cubeList.add(new ModelBox(ear, 0, 2, -1.0F, 1.0F, -2.0F, 2, 1, 1, 0.0F, false));
		ear.cubeList.add(new ModelBox(ear, 4, 4, -0.5F, 1.0F, -3.0F, 1, 1, 1, 0.0F, false));

		ear2 = new ModelRenderer(this);
		ear2.setRotationPoint(4.0F, -9.0F, -2.0F);
		setRotationAngle(ear2, -1.5708F, 0.0F, 0.0F);
		ear2.cubeList.add(new ModelBox(ear2, 0, 0, -2.0F, 1.0F, -1.0F, 2, 1, 1, 0.0F, false));
		ear2.cubeList.add(new ModelBox(ear2, 0, 4, -1.5F, 1.0F, -2.0F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Tail.render(f5);
		Tail2.render(f5);
		ear.render(f5);
		ear2.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}