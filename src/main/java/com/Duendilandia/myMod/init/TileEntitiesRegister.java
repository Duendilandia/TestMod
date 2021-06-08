package com.Duendilandia.myMod.init;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.tileentities.BasicAlterTileEntity;
import com.Duendilandia.myMod.common.tileentities.MixerCauldronTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntityType.Builder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntitiesRegister {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Main.MODID);
	
	public static final RegistryObject<TileEntityType<BasicAlterTileEntity>> BASIC_ALTER_TILE_ENTITY = TILE_ENTITIES_TYPES.register("basic_alter", () -> Builder.of(BasicAlterTileEntity::new, BlocksRegister.BASIC_ALTER.get()).build(null));
	public static final RegistryObject<TileEntityType<MixerCauldronTileEntity>> MIXER_CAULDRON_TILE_ENTITY = TILE_ENTITIES_TYPES.register("mixer_cauldron", () -> Builder.of(MixerCauldronTileEntity::new, BlocksRegister.MIXER_CAULDRON.get()).build(null));
}
