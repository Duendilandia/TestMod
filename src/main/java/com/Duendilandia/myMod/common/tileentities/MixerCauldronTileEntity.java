package com.Duendilandia.myMod.common.tileentities;

import com.Duendilandia.myMod.init.TileEntitiesRegister;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
public class MixerCauldronTileEntity extends TileEntity implements ITickableTileEntity{

	public int stirTicks;

	public MixerCauldronTileEntity(TileEntityType<?> tileEntityType) {
		super(tileEntityType);
		this.stirTicks = 0;
	}
	
	public MixerCauldronTileEntity() {
		this(TileEntitiesRegister.MIXER_CAULDRON_TILE_ENTITY.get());
	}

	@Override
	public void tick() {
		if (this.stirTicks > 0) {
	         --this.stirTicks;
		}
		
		/*if (this.stirTicks <= 0) {
	         this.stirTicks = 200;
		}*/
	}
	
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
		if (hand == Hand.MAIN_HAND) {
			this.stirTicks = 20;
		}

		return ActionResultType.SUCCESS;
	}
}
