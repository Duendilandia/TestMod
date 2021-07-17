package com.Duendilandia.myMod.init;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.items.BasicWand;
import com.Duendilandia.myMod.common.materials.ToolTiers;
import com.Duendilandia.myMod.tabs.ItemGropPrueba;

import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
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
	public static final RegistryObject<Item> CHYLOMICRON = ITEMS.register("chylomicron", () -> new Item(new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	
	public static final RegistryObject<Item> UNDERMINE_PICKAXE = ITEMS.register("undermine_pickaxe", () -> new PickaxeItem(ToolTiers.HELLENITE, 2, -2.8F, (new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB))));
	public static final RegistryObject<Item> SWORD_OF_LIFEBLOOD = ITEMS.register("sword_of_lifeblood", () -> new SwordItem(ToolTiers.HELLENITE, 4, -3.0F, (new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB))));
	
	public static final RegistryObject<BlockItem> CHROMITE_BLOCK = ITEMS.register("chromite_block", () -> new BlockItem(BlocksRegister.CHROMITE_BLOCK.get(), new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<BlockItem> BASIC_ALTER = ITEMS.register("basic_alter", () -> new BlockItem(BlocksRegister.BASIC_ALTER.get(), new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<BlockItem> MIXER_CAULDRON = ITEMS.register("mixer_cauldron", () -> new BlockItem(BlocksRegister.MIXER_CAULDRON.get(), new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	public static final RegistryObject<BlockItem> PILLAR = ITEMS.register("pillar", () -> new BlockItem(BlocksRegister.PILLAR.get(), new Item.Properties().tab(ItemGropPrueba.EXAMPLE_TAB)));
	
	/*public static final Item WOODEN_SWORD = registerItem("wooden_sword", new SwordItem(ItemTier.WOOD, 3, -2.4F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
   
   public static final Item STONE_SWORD = registerItem("stone_sword", new SwordItem(ItemTier.STONE, 3, -2.4F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
   
   public static final Item GOLDEN_SWORD = registerItem("golden_sword", new SwordItem(ItemTier.GOLD, 3, -2.4F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
   
   public static final Item IRON_SWORD = registerItem("iron_sword", new SwordItem(ItemTier.IRON, 3, -2.4F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
   
   public static final Item DIAMOND_SWORD = registerItem("diamond_sword", new SwordItem(ItemTier.DIAMOND, 3, -2.4F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
   
   public static final Item NETHERITE_SWORD = registerItem("netherite_sword", new SwordItem(ItemTier.NETHERITE, 3, -2.4F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT).fireResistant()));
   */
}
