package com.Duendilandia.myMod.common.particles;

import javax.annotation.Nullable;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class FlyParticle extends SpriteTexturedParticle{

	public FlyParticle(ClientWorld world, double xCoord, double yCoord, double zCoord, 
			double xSpeed, double ySpeed, double zSpeed, IAnimatedSprite spriteWithAge) {
		super(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
	    this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
	}
	
	@Override
	public void tick() {
		this.xo = this.x;
	    this.yo = this.y;
	    this.zo = this.z;
	}
	
	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}
	
	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite sprite;

		public Factory(IAnimatedSprite spriteIn) {
			this.sprite = spriteIn;
		}
		
		@Nullable
	    @Override
		public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, 
				double xSpeed, double ySpeed, double zSpeed) {
			FlyParticle particle = new FlyParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.sprite);
			return particle;
		}
	}
}
