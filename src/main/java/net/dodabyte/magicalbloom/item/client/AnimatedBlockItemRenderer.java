package net.dodabyte.magicalbloom.item.client;

import net.dodabyte.magicalbloom.item.animation.AnimatedBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedBlockItemRenderer extends GeoItemRenderer<AnimatedBlockItem> {
    public AnimatedBlockItemRenderer(String name) {
        super(new AnimatedBlockItemModel(name));
    }
}
