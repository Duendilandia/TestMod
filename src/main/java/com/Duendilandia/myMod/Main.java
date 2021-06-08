package com.Duendilandia.myMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Duendilandia.myMod.client.renderer.BasicAlterTileEntityRenderer;
import com.Duendilandia.myMod.client.renderer.MixerCauldronTileEntityRenderer;
import com.Duendilandia.myMod.client.screen.BasicAlterScreen;
import com.Duendilandia.myMod.common.particles.FlyParticle;
import com.Duendilandia.myMod.events.EventHandler;
import com.Duendilandia.myMod.init.BlocksRegister;
import com.Duendilandia.myMod.init.ContainersRegister;
import com.Duendilandia.myMod.init.ItemsRegister;
import com.Duendilandia.myMod.init.ParticlesRegister;
import com.Duendilandia.myMod.init.TileEntitiesRegister;

@Mod(Main.MODID)
public class Main {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "mymod";

    public Main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerFactories);
        
        ItemsRegister.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlocksRegister.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntitiesRegister.TILE_ENTITIES_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ContainersRegister.CONTAINERS_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ParticlesRegister.PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        //MinecraftForge.EVENT_BUS.register(new ParticlesRegister());
    }

    private void setup(final FMLCommonSetupEvent event) {
    	ClientRegistry.bindTileEntityRenderer(TileEntitiesRegister.BASIC_ALTER_TILE_ENTITY.get(), BasicAlterTileEntityRenderer::new);
    	ClientRegistry.bindTileEntityRenderer(TileEntitiesRegister.MIXER_CAULDRON_TILE_ENTITY.get(), MixerCauldronTileEntityRenderer::new);
    	ScreenManager.register(ContainersRegister.BASIC_ALTER_CONTAINER.get(), BasicAlterScreen::new);
    }
    
    private void clientSetup(final FMLClientSetupEvent event) {
    }
    
    /*public void registerFactories(ParticleFactoryRegisterEvent evt) {
		Minecraft.getInstance().particleEngine.register(ParticlesRegister.FLY_PARTICLE.get(), FlyParticle.Factory::new);
	}*/
}
