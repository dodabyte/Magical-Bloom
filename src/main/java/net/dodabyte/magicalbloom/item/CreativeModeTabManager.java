package net.dodabyte.magicalbloom.item;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.block.BlocksManager;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeTabManager {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MagicalBloom.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAGICAL_BLOOM_TAB =
            CREATIVE_MODE_TABS.register("magical_bloom_tab", () ->
                    CreativeModeTab.builder().icon(() -> new ItemStack(ItemsManager.MAGIC_CRYSTAL.get()))
                            .title(Component.translatable("creativetab.magicalbloom_tab"))
                            .displayItems(CreativeModeTabManager::itemsAccept)
                            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    private static void itemsAccept(CreativeModeTab.ItemDisplayParameters pParameters,
                             CreativeModeTab.Output pOutput) {
        for (RegistryObject<Item> item : ItemsManager.getItemsCollection()) {
            pOutput.accept(item.get());
        }
        for (RegistryObject<Block> block : BlocksManager.getBlocksCollection()) {
            pOutput.accept(block.get());
        }
    }
}
