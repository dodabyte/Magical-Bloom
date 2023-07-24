package net.dodabyte.magicalbloom.world.features;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.world.features.ores.CrystalFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber
public class FeaturesManager {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, MagicalBloom.MOD_ID);

    public static final RegistryObject<Feature<?>> CRYSTAL = FEATURES.register("crystal", CrystalFeature::new);

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
