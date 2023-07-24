package net.dodabyte.magicalbloom.datagen;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicalBloom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new CustomRecipeProvider(output));
        generator.addProvider(true, CustomLootTableProvider.create(output));
        generator.addProvider(true, new CustomBlockStateProvider(output, existingFileHelper));
        generator.addProvider(true, new CustomItemModelProvider(output, existingFileHelper));

    }
}
