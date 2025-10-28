/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.item.Item
 *  net.minecraftforge.registries.DeferredRegister
 *  net.minecraftforge.registries.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.RegistryObject
 */
package net.mcreator.artefactos.init;

import net.mcreator.artefactos.item.AmuleteDebrujoItem;
import net.mcreator.artefactos.item.CatalizadorNItem;
import net.mcreator.artefactos.item.ReliquiaDelReyGolemItem;
import net.mcreator.artefactos.item.AmuleteDeClerigoItem;
import net.mcreator.artefactos.item.ManzanaDeNotchSupremaItem;
import net.mcreator.artefactos.item.CorazonDeHydraItem;
import net.mcreator.artefactos.item.CalizDePonceDeLeonItem;
import net.mcreator.artefactos.item.AmuleteDeReinaHeladaItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class ArtefactosModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create((IForgeRegistry)ForgeRegistries.ITEMS, (String)"artefactos");
    public static final RegistryObject<Item> AMULETODEBRUJO = REGISTRY.register("amuletodebrujo", () -> new AmuleteDebrujoItem());
    public static final RegistryObject<Item> CORAZONDEHYDRA = REGISTRY.register("corazondehydra", () -> new CorazonDeHydraItem());
    public static final RegistryObject<Item> AMULETODECLERIGO = REGISTRY.register("amuletodeclerigo", () -> new AmuleteDeClerigoItem());
    public static final RegistryObject<Item> CATALIZADORN = REGISTRY.register("catalizadorn", () -> new CatalizadorNItem());
    public static final RegistryObject<Item> AMULETODELAREINAHELADA = REGISTRY.register("amuletodelareinahelada", () -> new AmuleteDeReinaHeladaItem());
    public static final RegistryObject<Item> RELIQUIADELREYGOLEM = REGISTRY.register("reliquiadelreygolem", () -> new ReliquiaDelReyGolemItem());
    public static final RegistryObject<Item> MANZANADENOTCHSUPREMA = REGISTRY.register("manzanadenotchsuprema", () -> new ManzanaDeNotchSupremaItem());
    public static final RegistryObject<Item> CALIZDEPONCEDELEON = REGISTRY.register("calizdeponcedeleon", () -> new CalizDePonceDeLeonItem());
}

