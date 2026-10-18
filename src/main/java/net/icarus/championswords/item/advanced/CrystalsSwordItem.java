package net.icarus.championswords.item.advanced;

import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.network.chat.Component;
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

public class CrystalsSwordItem extends AbstractCustomSwordItem {
    public CrystalsSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_ONE_TOOL_MATERIAL, 120);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        Vec3 direction = player.getLookAngle();
        Vec3 source = player.getEyePosition();
        Vec3 end = source.add(direction.normalize().scale(10));
        AABB box = new AABB(source, end).inflate(10);
        List<Entity> hitEntities = level.getEntities(player, box);
        if (!hitEntities.isEmpty()) {
            player.getItemInHand(hand).hurtAndBreak(50, player, hand);
            for (Entity entity : hitEntities) {
                if (entity instanceof LivingEntity livingEntity) {
                    level.explode(player, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 4.0f, Level.ExplosionInteraction.BLOCK);
                }
            }
            return InteractionResult.SUCCESS;
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
        return ModItems.CRYSTALS_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.crystals_sword.one"),
                Component.translatable("tooltip.champion-swords.crystals_sword.two"),
                Component.translatable("tooltip.champion-swords.crystals_sword.three")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 0;
    }
}
