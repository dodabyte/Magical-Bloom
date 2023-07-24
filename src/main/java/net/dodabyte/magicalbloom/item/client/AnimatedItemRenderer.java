package net.dodabyte.magicalbloom.item.client;

import net.dodabyte.magicalbloom.item.animation.AnimatedItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedItemRenderer extends GeoItemRenderer<AnimatedItem> {
    public AnimatedItemRenderer(String name) {
        super(new AnimatedItemModel(name));
    }
}
