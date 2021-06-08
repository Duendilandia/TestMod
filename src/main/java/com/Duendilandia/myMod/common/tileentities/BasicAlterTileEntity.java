package com.Duendilandia.myMod.common.tileentities;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.containers.BasicAlterContainer;
import com.Duendilandia.myMod.init.TileEntitiesRegister;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BasicAlterTileEntity extends LockableLootTileEntity{
	
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
}
