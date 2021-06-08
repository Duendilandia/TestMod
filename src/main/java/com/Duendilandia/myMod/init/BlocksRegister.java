package com.Duendilandia.myMod.init;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.blocks.BasicAlterBlock;
import com.Duendilandia.myMod.common.blocks.MixerCauldronBlock;
import com.Duendilandia.myMod.common.blocks.PillarBlock;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksRegister {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);
	
	public static final RegistryObject<Block> CHROMITE_BLOCK = BLOCKS.register("chromite_block", () -> new Block(Properties.of(Material.STONE)));
	public static final RegistryObject<BasicAlterBlock> BASIC_ALTER = BLOCKS.register("basic_alter", () -> new BasicAlterBlock(Properties.of(Material.STONE)));
	public static final RegistryObject<MixerCauldronBlock> MIXER_CAULDRON = BLOCKS.register("mixer_cauldron", () -> new MixerCauldronBlock(Properties.of(Material.STONE)));
	public static final RegistryObject<PillarBlock> PILLAR = BLOCKS.register("pillar", () -> new PillarBlock(Properties.of(Material.STONE)));
}
