package net.dodabyte.magicalbloom.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class CrystalAdditionalGenerationConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        return y <= 40 && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR;
    }
}
