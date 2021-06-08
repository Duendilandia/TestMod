package com.Duendilandia.myMod.common.blocks;

import java.util.Random;

import com.Duendilandia.myMod.common.tileentities.MixerCauldronTileEntity;
import com.Duendilandia.myMod.init.ParticlesRegister;
import com.Duendilandia.myMod.init.TileEntitiesRegister;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class MixerCauldronBlock extends Block{

	public static final VoxelShape SHAPE = VoxelShapes.or(Block.box(2, 0, 2, 14, 5, 14), Block.box(13, 2, 3, 16, 14, 13), Block.box(0, 2, 3, 3, 14, 13),  Block.box(0, 2, 13, 16, 14, 16), 
			Block.box(0, 2, 0, 16, 14, 3), Block.box(1, 14, 3, 3, 16, 13), Block.box(1, 14, 13, 15, 16, 15), Block.box(1, 14, 1, 15, 16, 3), Block.box(13, 14, 3, 15, 16, 13));
	
	public MixerCauldronBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState blockState) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState blockState, IBlockReader world) {
		return TileEntitiesRegister.MIXER_CAULDRON_TILE_ENTITY.get().create();
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
	      return this.getShape(state, world, pos, context);
	   }
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState blockState, World world, BlockPos pos, Random rand) {
		double d0 = pos.getX() + 0.3F + rand.nextFloat() * 0.6F;
		double d1 = pos.getY();
		double d2 = pos.getZ() + 0.3F + rand.nextFloat() * 0.6F;
		world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, d0, d1 + 1.25F, d2, 0.0D, 0.05D, 0.0D);
		world.addParticle((IParticleData) ParticlesRegister.FLY_PARTICLE.get(), d0, d1 + 1.25F, d2, 0.0D, 0.05D, 0.0D);
		world.addParticle(ParticleTypes.BUBBLE, d0, pos.getY() + 0.9375F, d2, 0.0D, 0.05D, 0.0D);
	}
	
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		if (!world.isClientSide) {
			TileEntity te = world.getBlockEntity(pos);
			if(te instanceof MixerCauldronTileEntity) {
				((MixerCauldronTileEntity) te).stirTicks = 20;
			}
		}

		return ActionResultType.SUCCESS;
	}
	
	public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		System.out.println (state + ", " + worldIn + ", " + pos + ", " + entityIn);
	}
}
