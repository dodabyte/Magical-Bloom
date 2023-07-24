package net.dodabyte.magicalbloom.item.client;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.item.animation.AnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedItemModel extends GeoModel<AnimatedItem> {
    private final String modelResourcePath;
    private final String textureResourcePath;
    private final String animationResourcePath;

    public AnimatedItemModel(String name) {
        this.modelResourcePath = "geo/" + name + ".geo.json";
        this.textureResourcePath = "textures/item/" + name + ".png";
        this.animationResourcePath = "animations/" + name + ".animation.json";
    }

    @Override
    public ResourceLocation getModelResource(AnimatedItem animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, modelResourcePath);
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, textureResourcePath);
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatable) {
        return new ResourceLocation(MagicalBloom.MOD_ID, animationResourcePath);
    }
}
