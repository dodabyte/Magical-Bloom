package net.dodabyte.magicalbloom.block.entity;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.block.BlocksManager;
import net.dodabyte.magicalbloom.block.entity.custom.AltarBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntitiesManager {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MagicalBloom.MOD_ID);

    public static final RegistryObject<BlockEntityType<AltarBlockEntity>> ALTAR_ENTITY =
            BLOCK_ENTITIES.register("altar_entity", () ->
                    BlockEntityType.Builder.of(AltarBlockEntity::new,
                            BlocksManager.ALTAR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
