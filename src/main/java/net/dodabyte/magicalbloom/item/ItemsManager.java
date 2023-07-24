package net.dodabyte.magicalbloom.item;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.item.custom.MediumStaff;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

public class ItemsManager {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MagicalBloom.MOD_ID);
    public static final RegistryObject<Item> SMALL_MAGIC_CRYSTAL =
            ITEMS.register("small_magic_crystal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_CRYSTAL =
            ITEMS.register("magic_crystal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_STAFF =
            ITEMS.register("medium_staff", () -> new MediumStaff(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static Collection<RegistryObject<Item>> getItemsCollection() {
        return ITEMS.getEntries();
    }
}
