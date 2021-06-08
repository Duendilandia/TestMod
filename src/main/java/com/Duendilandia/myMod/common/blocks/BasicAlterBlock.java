package com.Duendilandia.myMod.common.blocks;

import com.Duendilandia.myMod.common.tileentities.BasicAlterTileEntity;
import com.Duendilandia.myMod.init.TileEntitiesRegister;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BasicAlterBlock extends Block{

	public static final VoxelShape SHAPE = VoxelShapes.or(Block.box(1, 0, 1, 15, 2, 15), Block.box(5, 2, 5, 11, 10, 11), Block.box(0, 10, 0, 16, 14, 16));
	
	public BasicAlterBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState blockState) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState blockState, IBlockReader world) {
		return TileEntitiesRegister.BASIC_ALTER_TILE_ENTITY.get().create();
	}
	
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		if (!world.isClientSide) {
			TileEntity te = world.getBlockEntity(pos);
			if(te instanceof BasicAlterTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (BasicAlterTileEntity) te, pos);
			}
		}

		return ActionResultType.SUCCESS;
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
}
