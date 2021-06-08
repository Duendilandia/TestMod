package com.Duendilandia.myMod.init;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.particles.FlyParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ParticlesRegister {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Main.MODID);
	
	public static final RegistryObject<ParticleType<BasicParticleType>> FLY_PARTICLE = PARTICLE_TYPES.register("fly_particle", () -> new BasicParticleType(true));
	
	@SubscribeEvent
	public static void registerFactories(ParticleFactoryRegisterEvent evt) {
		Minecraft.getInstance().particleEngine.register(ParticlesRegister.FLY_PARTICLE.get(), FlyParticle.Factory::new);
	}
}
