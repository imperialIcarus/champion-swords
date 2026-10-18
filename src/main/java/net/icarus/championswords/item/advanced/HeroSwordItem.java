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

public class HeroSwordItem extends AbstractCustomSwordItem {
    public HeroSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_TWO_TOOL_MATERIAL, 0);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        return InteractionResult.FAIL;
    }

    @Override
    public List<MobEffectInstance> getStatusEffects() {
        return List.of(
                new MobEffectInstance(MobEffects.STRENGTH, 5, 1),
                new MobEffectInstance(MobEffects.SPEED, 5, 1),
                new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 5, 4)
        );
    }

    @Override
    public List<MobEffectInstance> getAppliedEffects() {
        return List.of();
    }

    @Override
    public Item getAsItem() {
        return ModItems.HERO_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.hero_sword")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 0;
    }
}
