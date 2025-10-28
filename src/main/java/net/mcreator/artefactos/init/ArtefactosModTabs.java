package net.mcreator.artefactos.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ArtefactosModTabs {
    public static final CreativeModeTab ARTIFACTS = new CreativeModeTab("artefactos_main") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ArtefactosModItems.AMULETODECLERIGO.get());
        }
    };
}
