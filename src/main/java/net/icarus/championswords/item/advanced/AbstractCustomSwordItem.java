package net.icarus.championswords.item.advanced;

import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

// Abstract Class for Swords, all other swords use this one's methods/fields
public abstract class AbstractCustomSwordItem extends Item {

    public AbstractCustomSwordItem(Properties properties, ToolMaterial tier, int useCooldown) {
        Rarity rarity = Rarity.COMMON;
        if (tier.equals(ModToolMaterials.TIER_ONE_TOOL_MATERIAL)) {
            rarity = Rarity.UNCOMMON;
        } else if (tier.equals(ModToolMaterials.TIER_TWO_TOOL_MATERIAL)) {
            rarity = Rarity.RARE;
        } else if (tier.equals(ModToolMaterials.TIER_THREE_TOOL_MATERIAL)) {
            rarity = Rarity.EPIC;
        }
        super(properties.sword(tier, 3.0f, -2.4f).rarity(rarity).useCooldown(useCooldown));
    }

    // Abstract methods to supply information
    public abstract InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand);
    public abstract List<MobEffectInstance> getStatusEffects();
    public abstract List<MobEffectInstance> getAppliedEffects();
    public abstract Item getAsItem();
    public abstract List<Component> getLore();
    public abstract int getDurabilityCost();
    // Does the right click ability when shift clicked and consumes durability
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (player.isCrouching() && hand.equals(InteractionHand.MAIN_HAND)) {
            player.getItemInHand(hand).hurtAndBreak(getDurabilityCost(), player, hand);
            return doRightClickAbility(level, player, hand);
        }
        else return InteractionResult.FAIL;
    }

    // Adds effects
    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        super.inventoryTick(itemStack, level, owner, slot);
        if (!level.isClientSide()) {
            if (owner instanceof Player player) {
                if(player.getItemInHand(InteractionHand.MAIN_HAND).is(getAsItem()) && !getStatusEffects().isEmpty()) {
                    for (MobEffectInstance effect : getStatusEffects()) {
                        player.addEffect(effect);
                    }
                }

            }
        }
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        super.hurtEnemy(itemStack, mob, attacker);
        if (!getAppliedEffects().isEmpty()) {
            for (MobEffectInstance effect : getAppliedEffects()) {
                mob.addEffect(effect);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if (!Minecraft.getInstance().hasShiftDown()) {
            builder.accept(Component.translatable("tooltip.champion-swords.unshifted"));
        } else {
            for (Component line : getLore()) {
                builder.accept(line);
            }
        }
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

}
