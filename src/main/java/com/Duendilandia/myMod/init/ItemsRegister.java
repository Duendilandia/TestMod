package com.Duendilandia.myMod.init;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.items.BasicWand;
import com.Duendilandia.myMod.common.naterials.HelleniteMaterial;
import com.Duendilandia.myMod.tabs.ItemGropPrueba;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsRegister {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
	
	public static final RegistryObject<Item> CHORMITE_FRAGMENT = ITEMS.register("chromite_fragment", () -> new Item(new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<BasicWand> BASIC_WAND = ITEMS.register("basic_wand", () -> new BasicWand(new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<Item> AMBER = ITEMS.register("amber", () -> new Item(new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<Item> HELLENIAN = ITEMS.register("hellenian", () -> new Item(new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<Item> BAUXITE = ITEMS.register("bauxite", () -> new Item(new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	
	public static final RegistryObject<Item> M = ITEMS.register("mineral_pickaxe", () -> new PickaxeItem(ItemTier.DIAMOND, 1, -2.8F, (new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB))));
	public static final RegistryObject<Item> MA = ITEMS.register("mineral_pickaxea", () -> new SwordItem(ItemTier.DIAMOND, 5, -2F, (new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB))));
	
	public static final RegistryObject<BlockItem> CHROMITE_BLOCK = ITEMS.register("chromite_block", () -> new BlockItem(BlocksRegister.CHROMITE_BLOCK.get(), new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<BlockItem> BASIC_ALTER = ITEMS.register("basic_alter", () -> new BlockItem(BlocksRegister.BASIC_ALTER.get(), new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<BlockItem> MIXER_CAULDRON = ITEMS.register("mixer_cauldron", () -> new BlockItem(BlocksRegister.MIXER_CAULDRON.get(), new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<BlockItem> PILLAR = ITEMS.register("pillar", () -> new BlockItem(BlocksRegister.PILLAR.get(), new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
}
