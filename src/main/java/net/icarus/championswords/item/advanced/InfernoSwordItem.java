package net.icarus.championswords.item.advanced;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.Fireball;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.entity.projectile.hurtingprojectile.WitherSkull;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class InfernoSwordItem extends AbstractCustomSwordItem {

    public InfernoSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_TWO_TOOL_MATERIAL, 30);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                int count = 20;
                @Override
                public void run() {
                    Vec3 direction = player.getLookAngle();
                    if (count % 2 == 0) {
                        Projectile.spawnProjectileFromRotation((serverLevel, entity, itemStack) -> new WitherSkull(serverLevel, entity, direction),
                                (ServerLevel) level,
                                player.getItemInHand(hand),
                                player,
                                -1f,
                                3f,
                                1f
                        );
                    } else if (count % 2 == 1) {
                        Projectile.spawnProjectileFromRotation((serverLevel, entity, itemStack) -> new SmallFireball(serverLevel, entity, direction) {
                                },
                                (ServerLevel) level,
                                player.getItemInHand(hand),
                                player,
                                -1f,
                                3f,
                                1f
                        );
                    }
                    count--;
                    if (count == 0) {
                        timer.cancel();
                    }

                }
            };
            timer.schedule(timerTask, 0, 150);
        }
        return InteractionResult.SUCCESS;
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
        return ModItems.INFERNO_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.inferno_sword.one"),
                Component.translatable("tooltip.champion-swords.inferno_sword.two"),
                Component.translatable("tooltip.champion-swords.inferno_sword.three")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 10;
    }
}
