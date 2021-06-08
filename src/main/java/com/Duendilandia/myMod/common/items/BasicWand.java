package com.Duendilandia.myMod.common.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BasicWand extends Item{

	public BasicWand(Properties properties) {
		super(properties);
	}
	
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		/*System.out.println("prueba");
		Vector3d vector = playerIn.getDeltaMovement();
		playerIn.setDeltaMovement(vector.x, 0.5F, vector.z);
		return ActionResult.pass(playerIn.getItemInHand(handIn));*/
		
		//////////////////////////////varitta de teletransporte con click
		/////////////
		
		Vector3d lookPos = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.NONE).getLocation();
		playerIn.setPos(lookPos.x, lookPos.y, lookPos.z);
		playerIn.fallDistance = 0F;
		
		System.out.println(getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.NONE).hitInfo);
		
		return super.use(worldIn, playerIn, handIn);
	}
	
	@Override
    public void appendHoverText(ItemStack stack, @Nullable World reader, List<ITextComponent> tooltip, ITooltipFlag flasg) {
		tooltip.add(new StringTextComponent("message.firstblock"));
		tooltip.add(new StringTextComponent("message.firstblock"));
		tooltip.add(new StringTextComponent("message.firstblock"));
		tooltip.add(new StringTextComponent("message.firstblock"));
    }
	
	protected static BlockRayTraceResult getPlayerPOVHitResult(World p_219968_0_, PlayerEntity p_219968_1_, RayTraceContext.FluidMode p_219968_2_) {
		double range = 10.0F;
		
		float f = p_219968_1_.xRot;
		float f1 = p_219968_1_.yRot;
		Vector3d vector3d = p_219968_1_.getEyePosition(1.0F);
		float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
		float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
		float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
		float f6 = f3 * f4;
		float f7 = f2 * f4;
			      
		Vector3d vector3d1 = vector3d.add((double)f6 * range, (double)f5 * range, (double)f7 * range);
		return p_219968_0_.clip(new RayTraceContext(vector3d, vector3d1, RayTraceContext.BlockMode.OUTLINE, p_219968_2_, p_219968_1_));
	}
}
