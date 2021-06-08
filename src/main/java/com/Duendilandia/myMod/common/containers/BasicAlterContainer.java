package com.Duendilandia.myMod.common.containers;

import java.util.Objects;

import com.Duendilandia.myMod.common.tileentities.BasicAlterTileEntity;
import com.Duendilandia.myMod.init.BlocksRegister;
import com.Duendilandia.myMod.init.ContainersRegister;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;

public class BasicAlterContainer extends Container implements ITickableTileEntity{

	public final BasicAlterTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;
	
	public BasicAlterContainer(int windowId, PlayerInventory playerInventory, BasicAlterTileEntity tileEntity) {
		super(ContainersRegister.BASIC_ALTER_CONTAINER.get(), windowId);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.create(tileEntity.getLevel(), tileEntity.getBlockPos());
		
		this.addSlot(new WandSlot(tileEntity, 0, 152, 58));
		this.addSlot(new Slot(tileEntity, 1, 39, 57));
		this.addSlot(new Slot(tileEntity, 2, 58, 37));
		this.addSlot(new Slot(tileEntity, 3, 78, 57));
		this.addSlot(new Slot(tileEntity, 4, 58, 77));
		
		//Main menu
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 9; column++) {
				this.addSlot(new Slot(playerInventory, column + row * 9 + 9, 16 + column * 18, 223 - (4 - row) * 18 - 10));
			}
		}
				
		//Hotbar
		for(int column = 0; column < 9; column++) {
			this.addSlot(new Slot(playerInventory, column, 16 + column * 18, 199));
		}
		
	}
	
	public BasicAlterContainer(int windowId, PlayerInventory playerInventory, PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	private static BasicAlterTileEntity getTileEntity(PlayerInventory playerInv, PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof BasicAlterTileEntity) {
			return (BasicAlterTileEntity) tileAtPos;
		}
		
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}
	
	@Override
	public boolean stillValid(PlayerEntity player) {
		return stillValid(canInteractWithCallable, player, BlocksRegister.BASIC_ALTER.get());
	}
	
	public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 36)
				if (!this.moveItemStackTo(itemstack1, BasicAlterTileEntity.slots, this.slots.size(), true)) {
				return ItemStack.EMPTY;
			} else if (!this.moveItemStackTo(itemstack1, 0, BasicAlterTileEntity.slots, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
		}
		return itemstack;
	}

	@Override
	public void tick() {
		if(new BlockPos(1, 60, 1) != null) {
			System.out.print("SI");
		}
	}
}
