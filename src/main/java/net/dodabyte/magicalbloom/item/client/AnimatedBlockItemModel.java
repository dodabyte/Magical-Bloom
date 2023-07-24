package net.dodabyte.magicalbloom.item.client;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.item.animation.AnimatedBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedBlockItemModel extends GeoModel<AnimatedBlockItem> {

    private final String modelResourcePath;
    private final String textureResourcePath;
    private final String animationResourcePath;

    public AnimatedBlockItemModel(String name) {
        this.modelResourcePath = "geo/" + name + ".geo.json";
        this.textureResourcePath = "textures/block/" + name + ".png";
        this.animationResourcePath = "animations/" + name + ".animation.json";
    }

    @Override
    public ResourceLocation getModelResource(AnimatedBlockItem animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, modelResourcePath);
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedBlockItem animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, textureResourcePath);
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedBlockItem animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, animationResourcePath);
    }
}
