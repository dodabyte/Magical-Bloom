package net.dodabyte.magicalbloom.world.features.ores;

import net.dodabyte.magicalbloom.procedures.CrystalAdditionalGenerationConditionProcedure;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class CrystalFeature extends OreFeature {
    public CrystalFeature() {
        super(OreConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreConfiguration> context) {
        WorldGenLevel world = context.level();

        if (!world.getLevel().dimension().equals(Level.OVERWORLD))
            return false;

        int x = context.origin().getX();
        int y = context.origin().getY();
        int z = context.origin().getZ();

        if (!CrystalAdditionalGenerationConditionProcedure.execute(world, x, y, z))
            return false;

        return super.place(context);
    }
}
