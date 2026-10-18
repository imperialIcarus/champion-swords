package net.icarus.championswords.item.advanced;

import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class BlazingSwordItem extends AbstractCustomSwordItem {
    public BlazingSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_ONE_TOOL_MATERIAL, 0);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        return InteractionResult.FAIL;
    }

    @Override
    public List<MobEffectInstance> getStatusEffects() {
        return List.of(
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20)
        );
    }

    @Override
    public List<MobEffectInstance> getAppliedEffects() {
        return List.of();
    }

    @Override
    public Item getAsItem() {
        return ModItems.BLAZING_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.blazing_sword.one"),
                Component.translatable("tooltip.champion-swords.blazing_sword.two")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 0;
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        super.hurtEnemy(itemStack, mob, attacker);
        if (mob.isOnFire() && mob.getRemainingFireTicks() <= 600) {
            mob.setRemainingFireTicks(600);
        } else if (!mob.isOnFire()) {
            mob.igniteForTicks(600);
        }
    }
}
