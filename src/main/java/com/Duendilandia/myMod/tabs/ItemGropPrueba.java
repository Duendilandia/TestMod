package com.Duendilandia.myMod.tabs;

import com.Duendilandia.myMod.init.ItemsRegister;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGropPrueba extends ItemGroup{

	public static final ItemGroup EXAMPLE_TAB = new ItemGropPrueba(ItemGroup.TABS.length, "example_tab");
	
	public ItemGropPrueba(int index, String name) {
		super(index, name);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemsRegister.BASIC_WAND.get());
	}

}
