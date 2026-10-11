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

public abstract class AbstractCustomSwordItem extends Item {
    public static ToolMaterial TIER;
    public static int USE_COOLDOWN;
    public static int DURABILITY_COST;
    public static Item ITEM_REFERENCE;
    public static List<MobEffectInstance> STATUS_EFFECTS;
    public static List<MobEffectInstance> APPLIED_EFFECTS;
    public static List<Component> LORE;

    public AbstractCustomSwordItem(Properties properties) {
        Rarity rarity = Rarity.COMMON;
        if (TIER.equals(ModToolMaterials.TIER_ONE_TOOL_MATERIAL)) {
            rarity = Rarity.UNCOMMON;
        } else if (TIER.equals(ModToolMaterials.TIER_TWO_TOOL_MATERIAL)) {
            rarity = Rarity.RARE;
        } else if (TIER.equals(ModToolMaterials.TIER_THREE_TOOL_MATERIAL)) {
            rarity = Rarity.EPIC;
        }
        super(properties.sword(TIER, 3.0f, -2.4f).rarity(rarity).useCooldown(USE_COOLDOWN));
    }

    abstract InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand);

    // Does the right click ability when shift clicked and consumes durability
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (player.isCrouching() && hand.equals(InteractionHand.MAIN_HAND)) {
            player.getItemInHand(hand).hurtAndBreak(DURABILITY_COST, player, hand);
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
                if(player.getItemInHand(InteractionHand.MAIN_HAND).is(ITEM_REFERENCE) && !STATUS_EFFECTS.isEmpty()) {
                    for (MobEffectInstance effect : STATUS_EFFECTS) {
                        player.addEffect(effect);
                    }
                }

            }
        }
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        super.hurtEnemy(itemStack, mob, attacker);
        if (!APPLIED_EFFECTS.isEmpty()) {
            for (MobEffectInstance effect : APPLIED_EFFECTS) {
                mob.addEffect(effect);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if (!Minecraft.getInstance().hasShiftDown()) {
            builder.accept(Component.translatable("tooltip.champion-swords.unshifted"));
        } else {
            for (Component line : LORE) {
                builder.accept(line);
            }
        }
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
