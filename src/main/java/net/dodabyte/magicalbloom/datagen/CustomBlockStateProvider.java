package net.dodabyte.magicalbloom.datagen;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.block.BlocksManager;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CustomBlockStateProvider extends BlockStateProvider {
    public CustomBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MagicalBloom.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlocksManager.CRYSTAL);
        blockWithItem(BlocksManager.MAGIC_CRYSTAL_BLOCK);
        blockWithItem(BlocksManager.ALTAR);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
