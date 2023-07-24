package net.dodabyte.magicalbloom;

import com.mojang.logging.LogUtils;
import net.dodabyte.magicalbloom.block.BlocksManager;
import net.dodabyte.magicalbloom.block.entity.BlockEntitiesManager;
import net.dodabyte.magicalbloom.block.entity.custom.AltarBlockEntity;
import net.dodabyte.magicalbloom.block.entity.client.AnimatedBlockRenderer;
import net.dodabyte.magicalbloom.item.CreativeModeTabManager;
import net.dodabyte.magicalbloom.item.ItemsManager;
import net.dodabyte.magicalbloom.world.features.FeaturesManager;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod(MagicalBloom.MOD_ID)
public class MagicalBloom {
    public static final String MOD_ID = "magicalbloom";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MagicalBloom() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GeckoLib.initialize();

        CreativeModeTabManager.register(modEventBus);

        ItemsManager.register(modEventBus);
        BlocksManager.register(modEventBus);
        BlockEntitiesManager.register(modEventBus);
        FeaturesManager.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BlocksManager.MAGIC_CRYSTAL_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(BlocksManager.ALTAR);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlocksManager.CRYSTAL);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemsManager.SMALL_MAGIC_CRYSTAL);
            event.accept(ItemsManager.MAGIC_CRYSTAL);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ItemsManager.MEDIUM_STAFF);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            BlockEntityRenderers.register(BlockEntitiesManager.ALTAR_ENTITY.get(),
                    (BlockEntityRendererProvider.Context context) ->
                            new AnimatedBlockRenderer<AltarBlockEntity>(BlocksManager.ALTAR.get().
                                    getDescriptionId().split("\\.")[2]));
        }
    }
}
