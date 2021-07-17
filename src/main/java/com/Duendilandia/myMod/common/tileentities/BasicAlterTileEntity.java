package com.Duendilandia.myMod.common.tileentities;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.blocks.BasicAlterBlock;
import com.Duendilandia.myMod.common.containers.BasicAlterContainer;
import com.Duendilandia.myMod.init.BlocksRegister;
import com.Duendilandia.myMod.init.TileEntitiesRegister;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.fixes.ChunkPaletteFormat.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BasicAlterTileEntity extends LockableLootTileEntity implements ITickableTileEntity{
	
	public static int slots = 5;
	private NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

	public BasicAlterTileEntity(TileEntityType<?> tileEntityType) {
		super(tileEntityType);
	}
	
	public BasicAlterTileEntity() {
		this(TileEntitiesRegister.BASIC_ALTER_TILE_ENTITY.get());
	}

	@Override
	public int getContainerSize() {
		return slots;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.items = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container." + Main.MODID + ".basic_alter");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new BasicAlterContainer(id, player, this);
	}

	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
	    if (!this.trySaveLootTable(compound)) {
	    	ItemStackHelper.saveAllItems(compound, this.items);
	    }

	    return compound;
	}
	
	public void load(BlockState state, CompoundNBT compound) {
		super.load(state, compound);
	    this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
	    if (!this.tryLoadLootTable(compound)) {
	    	ItemStackHelper.loadAllItems(compound, this.items);
	    }
	}
	
	public ItemStack getItem() {
		return this.items.get(0);
	}

	@Override
	public void tick() {
		System.out.println(this.getBlockState().getValue(BasicAlterBlock.HORIZONTAL_FACING));
		/*if(this.getBlockState().getValue(BasicAlterBlock.HORIZONTAL_FACING).equals(BasicAlterBlock.gets)) {
			System.out.println("FUNCIONA");
		}*/
		BlockPos frontPillar = new BlockPos(this.getBlockPos().getX() + 3.0F, this.getBlockPos().getY(), this.getBlockPos().getZ() - 1.0F);
		BlockPos behindPillar = new BlockPos(this.getBlockPos().getX() + 3.0F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 1.0F);
		BlockPos rightPillar = new BlockPos(this.getBlockPos().getX() - 3.0F, this.getBlockPos().getY(), this.getBlockPos().getZ() - 1.0F);
		BlockPos leftPillar = new BlockPos(this.getBlockPos().getX() - 3.0F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 1.0F);
		BlockPos rightPillar2 = new BlockPos(this.getBlockPos().getX() - 1.0F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 3.0F);
		BlockPos leftPillar2 = new BlockPos(this.getBlockPos().getX() + 1.0F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 3.0F);
		if(this.getLevel().getBlockState(frontPillar).getBlock() == BlocksRegister.PILLAR.get() && 
				this.getLevel().getBlockState(behindPillar).getBlock() == BlocksRegister.PILLAR.get() && 
				this.getLevel().getBlockState(rightPillar).getBlock() == BlocksRegister.PILLAR.get() && 
				this.getLevel().getBlockState(leftPillar).getBlock() == BlocksRegister.PILLAR.get() && 
				this.getLevel().getBlockState(rightPillar2).getBlock() == BlocksRegister.PILLAR.get() && 
				this.getLevel().getBlockState(leftPillar2).getBlock() == BlocksRegister.PILLAR.get()){
			System.out.println("ACTIVADO");
		}
	}
}
