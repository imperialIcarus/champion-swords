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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.WitherSkull;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.List;

public class EyeSwordItem extends AbstractCustomSwordItem {
    public EyeSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_ONE_TOOL_MATERIAL, 10);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
            Projectile.spawnProjectileFromRotation(ThrownEnderpearl::new,
                    (ServerLevel) level,
                    Items.ENDER_PEARL.getDefaultInstance(),
                    player,
                    0.5f,
                    1.5f,
                    1f
            );
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
        return ModItems.EYE_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.eye_sword.one"),
                Component.translatable("tooltip.champion-swords.eye_sword.two"),
                Component.translatable("tooltip.champion-swords.eye_sword.three")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 10;
    }
}
