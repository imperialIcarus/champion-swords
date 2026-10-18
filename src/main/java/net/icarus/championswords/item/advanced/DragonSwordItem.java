package net.icarus.championswords.item.advanced;

import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.DragonFireball;
import net.minecraft.world.entity.projectile.hurtingprojectile.WitherSkull;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.List;

public class DragonSwordItem extends AbstractCustomSwordItem {
    public DragonSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_ONE_TOOL_MATERIAL, 5);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            Projectile.spawnProjectileFromRotation((serverLevel, entity, itemStack) -> new DragonFireball(serverLevel, entity, player.getLookAngle()),
                    (ServerLevel) level,
                    player.getItemInHand(hand),
                    player,
                    -1f,
                    2f,
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
        return ModItems.DRAGON_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.dragon_sword.one"),
                Component.translatable("tooltip.champion-swords.dragon_sword.two"),
                Component.translatable("tooltip.champion-swords.dragon_sword.three")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 5;
    }
}
