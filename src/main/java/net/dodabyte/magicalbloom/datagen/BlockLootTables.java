package net.dodabyte.magicalbloom.datagen;

import net.dodabyte.magicalbloom.block.BlocksManager;
import net.dodabyte.magicalbloom.item.ItemsManager;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelfBlock(BlocksManager.MAGIC_CRYSTAL_BLOCK);
        dropSelfBlock(BlocksManager.ALTAR);

        dropOre(BlocksManager.CRYSTAL, ItemsManager.SMALL_MAGIC_CRYSTAL);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlocksManager.getBlocksCollection().stream().map(RegistryObject::get)::iterator;
    }

    private void dropSelfBlock(RegistryObject<Block> blockRegistryObject) {
        dropSelf(blockRegistryObject.get());
    }

    private void dropOre(RegistryObject<Block> blockRegistryObject,
                         RegistryObject<Item> dropItemRegistryObject) {
        add(blockRegistryObject.get(), (block) -> createOreDrop(blockRegistryObject.get(), dropItemRegistryObject.get()).
                apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).
                apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));
    }
}
