package net.icarus.championswords.item.advanced;

import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class VoidSwordItem extends AbstractCustomSwordItem {
    public VoidSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_TWO_TOOL_MATERIAL, 120);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Vec3 direction = player.getLookAngle().scale(50);
            Vec3 source = player.getEyePosition();
            Vec3 end = source.add(direction.normalize().scale(10));
            AABB box = new AABB(source, end).inflate(10);
            List<Entity> hitEntities = level.getEntities(player, box);
            if (!hitEntities.isEmpty()) {
                player.getItemInHand(hand).hurtAndBreak(50, player, hand);
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_DRAGON_GROWL, SoundSource.PLAYERS, 3, 1);
                for (Entity entity : hitEntities) {
                    if (entity instanceof LivingEntity livingEntity) {
                        livingEntity.push(direction);
                        livingEntity.hurtServer((ServerLevel) level, level.damageSources().playerAttack(player), 10.0f);
                    }
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public List<MobEffectInstance> getStatusEffects() {
        return List.of();
    }

    @Override
    public List<MobEffectInstance> getAppliedEffects() {
        return List.of();
    }

    @Override
    public Item getAsItem() {
        return ModItems.VOID_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.void_sword.one"),
                Component.translatable("tooltip.champion-swords.void_sword.two"),
                Component.translatable("tooltip.champion-swords.void_sword.three")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 0;
    }
}
