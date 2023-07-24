package net.dodabyte.magicalbloom.block;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.block.custom.AltarAnimatedBlock;
import net.dodabyte.magicalbloom.block.custom.CrystalBlock;
import net.dodabyte.magicalbloom.item.ItemsManager;
import net.dodabyte.magicalbloom.item.animation.AnimatedBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.function.Supplier;

public class BlocksManager {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MagicalBloom.MOD_ID);

    public static final RegistryObject<Block> CRYSTAL = registerBlock("crystal",
            () -> new CrystalBlock(14, 2.5, BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).
                    strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGIC_CRYSTAL_BLOCK = registerBlock("magic_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ALTAR = registerAnimatedBlock("altar",
            () -> new AltarAnimatedBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Block> registerAnimatedBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, block);
        registerAnimatedBlockItem(name, toReturn);
        return toReturn;
    }

    private static void registerBlockItem(String name, RegistryObject<Block> block) {
        ItemsManager.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static void registerAnimatedBlockItem(String name, RegistryObject<Block> block) {
        ItemsManager.ITEMS.register(name, () -> new AnimatedBlockItem(name, block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static Collection<RegistryObject<Block>> getBlocksCollection() {
        return BLOCKS.getEntries();
    }
}
