package com.Duendilandia.myMod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class PillarBlock extends Block{
	
	public static BooleanProperty UP = BooleanProperty.create("up");
	   public static BooleanProperty DOWN = BooleanProperty.create("down");

	public PillarBlock(Properties properties) {
		//this.registerDefaultState(this.stateDefinition.any().setValue(UP, Boolean.valueOf(false)).setValue(DOWN, Boolean.valueOf(false)));
		super(properties);
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IBlockReader iblockreader = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
	    
	    return this.updateCorners(iblockreader, blockpos, super.getStateForPlacement(context));
	}
	
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {
		return this.updateCorners(world, pos, state);
	}
	
	protected BlockState updateCorners(IBlockReader world, BlockPos pos, BlockState state) {
		
	    BlockState blockstate1 = world.getBlockState(pos.below());
	    BlockState blockstate2 = world.getBlockState(pos.above());
	    
	    boolean conn1 = blockstate1.getBlock() == this;
	    boolean conn2 = blockstate2.getBlock() == this;
	    return state.setValue(UP, conn1).setValue(DOWN, conn2);
	}
	
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(UP, DOWN);
	   }
}
