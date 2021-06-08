package com.Duendilandia.myMod.common.containers;

import com.Duendilandia.myMod.init.ItemsRegister;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class WandSlot extends Slot{

	public WandSlot(IInventory inv, int index, int x, int y) {
		super(inv, index, x, y);
	}
	
	public boolean mayPlace(ItemStack stack) {
		if(stack.getItem().equals(ItemsRegister.BASIC_WAND.get())) {
	      return true;
	   }else {
		   return false;
	   }
	}
}
