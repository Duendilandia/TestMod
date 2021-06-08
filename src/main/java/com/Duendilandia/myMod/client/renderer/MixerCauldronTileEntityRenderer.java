package com.Duendilandia.myMod.client.renderer;

import com.Duendilandia.myMod.common.tileentities.MixerCauldronTileEntity;
import com.Duendilandia.myMod.init.ItemsRegister;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ColorHelper.PackedColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColors;

public class MixerCauldronTileEntityRenderer extends TileEntityRenderer<MixerCauldronTileEntity>{
	
	public static final ResourceLocation TEXTURE = new ResourceLocation("textures/block/water_still.png");
	
	float coeff;
	
	public MixerCauldronTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcher) {
		super(rendererDispatcher);
	}
	
	@Override
	public void render(MixerCauldronTileEntity tileEntity, float partialTicks, MatrixStack matrixStack,
			IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay ) {
		if(tileEntity.stirTicks == 0) {
			coeff = 0.0F;
		} else {
			coeff = ((float)tileEntity.stirTicks - partialTicks) / 20.0F;
		}
		
		TextureAtlasSprite water = (TextureAtlasSprite)Minecraft.getInstance().getTextureAtlas(AtlasTexture.LOCATION_BLOCKS).apply(new ResourceLocation("minecraft", "block/water_still"));
		IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.translucentNoCrumbling());
		Matrix4f matrix4f = matrixStack.last().pose();
		Matrix3f matrixNormal = matrixStack.last().normal();
		
		int color = BiomeColors.getAverageWaterColor(tileEntity.getLevel(), tileEntity.getBlockPos());
		int red = PackedColor.red(color);
		int green = PackedColor.green(color);
		int blue = PackedColor.blue(color);
		int alpha = PackedColor.alpha(color);
		
		int lightLevel = getLightLevel(tileEntity.getLevel(), tileEntity.getBlockPos().north());
		
		matrixStack.pushPose();
		matrixStack.translate(0.5F, 0.75F, 0.5F);
		matrixStack.scale(1.0F, 1.0F, 1.0f);

		//matrixStack.mulPose(Vector3f.YP.rotationDegrees(coeff  * 360.0F));
		//matrixStack.mulPose(Vector3f.XP.rotationDegrees(30.0F));
		matrixStack.translate(0.25F * Math.cos(coeff), 0, 0.25F * Math.sin(coeff));

		IBakedModel model = Minecraft.getInstance().getItemRenderer().getModel(new ItemStack(ItemsRegister.BASIC_WAND.get()), null, null);
		Minecraft.getInstance().getItemRenderer().render(new ItemStack(ItemsRegister.BASIC_WAND.get()), ItemCameraTransforms.TransformType.GROUND, true, matrixStack, buffer, lightLevel, combinedOverlay, model);		
		
		matrixStack.popPose();
		
		vertexBuilder.vertex(matrix4f, 0.8125F, 0.9375F, 0.1875F).color(red, green, blue, 192).uv(water.getU(3.0D), water.getV(3.0D)).overlayCoords(combinedOverlay).uv2(combinedLight).normal(matrixNormal, 0.0F, 1.0F, 0.0F).endVertex();
		vertexBuilder.vertex(matrix4f, 0.1875F, 0.9375F, 0.1875F).color(red, green, blue, 192).uv(water.getU(13.0D), water.getV(3.0D)).overlayCoords(combinedOverlay).uv2(combinedLight).normal(matrixNormal, 0.0F, 1.0F, 0.0F).endVertex();
		vertexBuilder.vertex(matrix4f, 0.1875F, 0.9375F, 0.8125F).color(red, green, blue, 192).uv(water.getU(13.0D), water.getV(13.0D)).overlayCoords(combinedOverlay).uv2(combinedLight).normal(matrixNormal, 0.0F, 1.0F, 0.0F).endVertex();
		vertexBuilder.vertex(matrix4f, 0.8125F, 0.9375F, 0.8125F).color(red, green, blue, 192).uv(water.getU(3.0D), water.getV(13.0D)).overlayCoords(combinedOverlay).uv2(combinedLight).normal(matrixNormal, 0.0F, 1.0F, 0.0F).endVertex();
	}
	
	private int getLightLevel(World world, BlockPos blockPos) {
		int bLight = world.getBrightness(LightType.BLOCK, blockPos);
		int sLight = world.getBrightness(LightType.SKY, blockPos);
		return LightTexture.pack(bLight, sLight);
	}
}
