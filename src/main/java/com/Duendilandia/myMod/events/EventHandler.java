package com.Duendilandia.myMod.events;

import com.Duendilandia.myMod.common.particles.FlyParticle;
import com.Duendilandia.myMod.init.BlocksRegister;
import com.Duendilandia.myMod.init.ItemsRegister;
import com.Duendilandia.myMod.init.ParticlesRegister;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class EventHandler {
	
	@SubscribeEvent
    public void pickupItem(BlockEvent.BreakEvent event) {
		System.out.println(event.getPlayer().getMainHandItem());
		if(event.getPlayer().getMainHandItem().equals(Items.DIAMOND_PICKAXE)) {
			for(int x = -1; x <= 1; x++) {
				for(int y = -1; y <= 1; y++) {
					for(int z = -1; z <= 1; z++) {
						event.getWorld().setBlock(event.getPos().offset(x, y, z), Blocks.AIR.defaultBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
					}
				}
			}
		}	
    }
	
	@SubscribeEvent
	public void registerBlockColors(ColorHandlerEvent.Block event){
		IBlockColor iBlockColor = (blockState, iEnviromentBlockReader, blockPos, i) -> Integer.decode("#16777184");
	    event.getBlockColors().register(iBlockColor, BlocksRegister.CHROMITE_BLOCK.get());
	}
	
	@SubscribeEvent
	public void deployParachute(TickEvent.PlayerTickEvent event) {
		PlayerEntity player = event.player;
		if (player.isCrouching()) {
			System.out.println("prueba");
			Vector3d vector = player.getDeltaMovement();
			player.setDeltaMovement(vector.x, 0.5F, vector.z);
		}
	}
}
