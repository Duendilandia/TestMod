package com.Duendilandia.myMod.init;

import com.Duendilandia.myMod.Main;
import com.Duendilandia.myMod.common.containers.BasicAlterContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.extensions.IForgeContainerType;

public class ContainersRegister {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MODID);
	
	public static final RegistryObject<ContainerType<BasicAlterContainer>> BASIC_ALTER_CONTAINER = CONTAINERS_TYPES.register("basic_alter", () -> IForgeContainerType.create(BasicAlterContainer::new));
	
}
