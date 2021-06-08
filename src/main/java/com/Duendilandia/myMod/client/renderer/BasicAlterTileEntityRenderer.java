package com.Duendilandia.myMod.client.renderer;

import com.Duendilandia.myMod.common.tileentities.BasicAlterTileEntity;
import com.Duendilandia.myMod.init.ItemsRegister;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class BasicAlterTileEntityRenderer extends TileEntityRenderer<BasicAlterTileEntity>{

	public BasicAlterTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcher) {
		super(rendererDispatcher);
	}

	public void render(BasicAlterTileEntity tileEntity, float partialTicks, MatrixStack matrixStack,
			IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
		if(tileEntity.getItem().equals(ItemStack.EMPTY)) {
			return;
		}
			int lightLevel = getLightLevel(tileEntity.getLevel(), tileEntity.getBlockPos().north());
			
			matrixStack.pushPose();
			matrixStack.translate(0.35f, 0.90625f, 0.35f);
			matrixStack.scale(1f, 1f, 1f);
			matrixStack.mulPose(Vector3f.XP.rotationDegrees(90));
			matrixStack.mulPose(Vector3f.ZP.rotationDegrees(15));
	
			IBakedModel wand = Minecraft.getInstance().getItemRenderer().getModel(new ItemStack(ItemsRegister.BASIC_WAND.get()), null, null);
			Minecraft.getInstance().getItemRenderer().render(new ItemStack(ItemsRegister.BASIC_WAND.get()), ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer, lightLevel, combinedOverlay, wand);		
			
			matrixStack.popPose();
	}
	
	private int getLightLevel(World world, BlockPos blockPos) {
		int bLight = world.getBrightness(LightType.BLOCK, blockPos);
		int sLight = world.getBrightness(LightType.SKY, blockPos);
		return LightTexture.pack(bLight, sLight);
	}
}
