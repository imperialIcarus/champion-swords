package net.icarus.championswords.item.advanced;

import com.mojang.datafixers.optics.Lens;
import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EchoesSwordItem extends AbstractCustomSwordItem{
    public EchoesSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_ONE_TOOL_MATERIAL, 120);
    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS);
            Vec3 source = player.getEyePosition();
            Vec3 delta = player.getLookAngle();
            Vec3 normalize = delta.normalize();
            int steps = Mth.floor(delta.length() + 10) + 10;
            Vec3 end = source.add(normalize.scale(steps));
            for (int i = 1; i < steps; ++i) {
                Vec3 particlePos = source.add(normalize.scale((double) i));
                level.addParticle(ParticleTypes.SONIC_BOOM, false, false, particlePos.x, particlePos.y, particlePos.z, (double) 0.0F, (double) 0.0F, (double) 0.0F);
            }

            if (level instanceof ServerLevel serverLevel) {
                AABB boundingBox = new AABB(source, end);
                boundingBox.inflate(10);
                List<Entity> hitEntities = serverLevel.getEntities(player, boundingBox);
                for (Entity hitEntity : hitEntities) {
                    if (hitEntity instanceof LivingEntity livingHitEntity) {
                        livingHitEntity.hurtServer(serverLevel, level.damageSources().sonicBoom(player), 10f);
                        double knockbackVertical = (double) 0.5F * ((double) 1.0F - livingHitEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                        double knockbackHorizontal = (double) 2.5F * ((double) 1.0F - livingHitEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                        livingHitEntity.push(normalize.x() * knockbackHorizontal, normalize.y() * knockbackVertical, normalize.z() * knockbackHorizontal);
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
        return null;
    }

    @Override
    public List<Component> getLore() {
        return List.of(Component.translatable("tooltip.champion-swords.echoes_sword.one"),
                Component.translatable("tooltip.champion-swords.echoes_sword.two"),
                Component.translatable("tooltip.champion-swords.echoes_sword.three"));
    }

    @Override
    public int getDurabilityCost() {
        return 50;
    }


}
