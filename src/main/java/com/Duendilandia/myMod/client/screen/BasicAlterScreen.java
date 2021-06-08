package com.Duendilandia.myMod.client.screen;

import java.awt.Color;

import javax.annotation.Nonnull;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.containers.BasicAlterContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BasicAlterScreen extends ContainerScreen<BasicAlterContainer>{
	
	private static final ResourceLocation BASIC_ALTER_GUI = new ResourceLocation(Main.MODID, "textures/gui/basic_alter.png");

	
	public BasicAlterScreen(BasicAlterContainer screenContainer, PlayerInventory playerInv, ITextComponent titleIn) {
		super(screenContainer, playerInv, titleIn);
		
		this.leftPos = 0;
		this.topPos = 0;
	    this.imageHeight = 223;
	    this.imageWidth = 184;
	}

	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}
	
	protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.minecraft.getTextureManager().bind(BASIC_ALTER_GUI);
	    int x = (this.width - this.imageWidth) / 2;
	    int y = (this.height - this.imageHeight) / 2;
	    this.blit(matrixStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
	}
	
	private static final ITextComponent TEXT = new TranslationTextComponent("container." + Main.MODID + ".alter_tier");
	
    protected void renderLabels(MatrixStack matrixStack, int x, int y) {
    	RenderSystem.disableBlend();
    	super.renderLabels(matrixStack, x, y);
    	//ITextComponent itextcomponent = TEXT;
        //this.font.draw(matrixStack, itextcomponent, 108.0F, 103.0F, 4210752);   
    }
}
