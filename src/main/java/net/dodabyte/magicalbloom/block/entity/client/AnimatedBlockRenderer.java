package net.dodabyte.magicalbloom.block.entity.client;

import net.minecraft.world.level.block.entity.BlockEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AnimatedBlockRenderer<T extends BlockEntity & GeoAnimatable> extends GeoBlockRenderer<T> {
    public AnimatedBlockRenderer(String name) {
        super(new AnimatedBlockModel<T>(name));
    }
}
