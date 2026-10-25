package net.icarus.championswords.item.advanced;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.Fireball;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.entity.projectile.hurtingprojectile.WitherSkull;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
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
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS);
        Vec3 source = player.getEyePosition();
        Vec3 delta = player.getLookAngle();
        Vec3 normalize = delta.normalize();
        int steps = Mth.floor(delta.length() + 10) + 6;
        Vec3 end = source.add(normalize.scale(steps));


        if (level instanceof ServerLevel serverLevel) {
            for (int i = 1; i < steps; ++i) {
                Vec3 particlePos = source.add(normalize.scale((double) i));
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x, particlePos.y, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x - 0.1, particlePos.y, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x + 0.1, particlePos.y, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x - 0.2, particlePos.y, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x + 0.2, particlePos.y, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x, particlePos.y - 0.1, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x, particlePos.y + 0.1, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x, particlePos.y - 0.2, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
                serverLevel.sendParticles(ParticleTypes.FLAME, particlePos.x, particlePos.y + 0.2, particlePos.z, 1, (double) 0.0F, (double) 0.0F, (double) 0.0F, (double) 0.0f);
            }
            AABB boundingBox = new AABB(source, end);
            boundingBox.inflate(7);
            List<Entity> hitEntities = serverLevel.getEntities(player, boundingBox);
            for (Entity hitEntity : hitEntities) {
                if (hitEntity instanceof LivingEntity livingHitEntity) {
                    livingHitEntity.hurtServer(serverLevel, level.damageSources().onFire(), 10f);
                    livingHitEntity.igniteForTicks(400);
                }
            }
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
