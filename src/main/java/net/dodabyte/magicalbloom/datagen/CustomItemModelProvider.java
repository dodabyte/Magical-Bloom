package net.dodabyte.magicalbloom.datagen;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.item.ItemsManager;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CustomItemModelProvider extends ItemModelProvider {
    public CustomItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MagicalBloom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemsManager.SMALL_MAGIC_CRYSTAL);
        simpleItem(ItemsManager.MAGIC_CRYSTAL);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MagicalBloom.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MagicalBloom.MOD_ID,"item/" + item.getId().getPath()));
    }

//    private ItemModelBuilder animatedItem(RegistryObject<Item> itemRegistryObject) {
//        return withExistingParent(itemRegistryObject.getId().getPath(),
//                new ResourceLocation(GeckoLib.MOD_ID, "builtin/entity")).texture("layer0",
//                new ResourceLocation(MagicalBloom.MOD_ID,"item/" + itemRegistryObject.getId().getPath()));
//    }
}
