package net.dodabyte.magicalbloom.item.custom;

import net.dodabyte.magicalbloom.item.animation.AnimatedItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MediumStaff extends AnimatedItem {
    public MediumStaff(Properties properties) {
        super("medium_staff", properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide() && usedHand == InteractionHand.MAIN_HAND) {
            player.getCooldowns().addCooldown(this, 40);
        }

        return super.use(level, player, usedHand);
    }
}
