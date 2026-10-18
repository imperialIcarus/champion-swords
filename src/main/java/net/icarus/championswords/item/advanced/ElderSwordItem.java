package net.icarus.championswords.item.advanced;

import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.List;

public class ElderSwordItem extends AbstractCustomSwordItem {
    public ElderSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_ONE_TOOL_MATERIAL, 0);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        return InteractionResult.FAIL;
    }

    @Override
    public List<MobEffectInstance> getStatusEffects() {
        return List.of();
    }

    @Override
    public List<MobEffectInstance> getAppliedEffects() {
        return List.of(
                new MobEffectInstance(MobEffects.MINING_FATIGUE, 100, 2),
                new MobEffectInstance(MobEffects.SLOWNESS, 100, 2)
        );
    }

    @Override
    public Item getAsItem() {
        return ModItems.ELDER_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.elder_sword")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 0;
    }
}
