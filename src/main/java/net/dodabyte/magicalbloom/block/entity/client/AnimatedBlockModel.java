package net.dodabyte.magicalbloom.block.entity.client;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedBlockModel<T extends GeoAnimatable> extends GeoModel<T> {
    private final String modelResourcePath;
    private final String textureResourcePath;
    private final String animationResourcePath;

    public AnimatedBlockModel(String name) {
        this.modelResourcePath = "geo/" + name + ".geo.json";
        this.textureResourcePath = "textures/block/" + name + ".png";
        this.animationResourcePath = "animations/" + name + ".animation.json";
    }

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, modelResourcePath);
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, textureResourcePath);
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, animationResourcePath);
    }
}
