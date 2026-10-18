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
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

import java.util.List;

public class ChampionSwordItem extends AbstractCustomSwordItem {
    public ChampionSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_THREE_TOOL_MATERIAL, 0);
    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
        return InteractionResult.FAIL;
    }

    @Override
    public List<MobEffectInstance> getStatusEffects() {
        return List.of(
                new MobEffectInstance(MobEffects.STRENGTH, 5, 2),
                new MobEffectInstance(MobEffects.SPEED, 5, 1),
                new MobEffectInstance(MobEffects.RESISTANCE, 5, 2),
                new MobEffectInstance(MobEffects.REGENERATION, 5, 1),
                new MobEffectInstance(MobEffects.HEALTH_BOOST, 5, 2),
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 5, 0),
                new MobEffectInstance(MobEffects.JUMP_BOOST, 5, 1),
                new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 5, 2),
                new MobEffectInstance(MobEffects.HASTE, 5, 2),
                new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 5, 4),
                new MobEffectInstance(MobEffects.SATURATION, 5, 0),
                new MobEffectInstance(MobEffects.LUCK, 5, 2)
        );
    }

    @Override
    public List<MobEffectInstance> getAppliedEffects() {
        return List.of(
                new MobEffectInstance(MobEffects.WEAKNESS, 200, 2),
                new MobEffectInstance(MobEffects.SLOWNESS, 200, 2),
                new MobEffectInstance(MobEffects.MINING_FATIGUE, 200, 2),
                new MobEffectInstance(MobEffects.BLINDNESS, 200, 0),
                new MobEffectInstance(MobEffects.WITHER, 200, 4),
                new MobEffectInstance(MobEffects.POISON, 200, 4),
                new MobEffectInstance(MobEffects.DARKNESS, 200, 0),
                new MobEffectInstance(MobEffects.HUNGER, 200, 4),
                new MobEffectInstance(MobEffects.NAUSEA, 200, 4),
                new MobEffectInstance(MobEffects.GLOWING, 200, 0),
                new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0),
                new MobEffectInstance(MobEffects.UNLUCK, 200, 4)
        );
    }

    @Override
    public Item getAsItem() {
        return ModItems.CHAMPION_SWORD;
    }

    @Override
    public List<Component> getLore() {
        return List.of(
                Component.translatable("tooltip.champion-swords.champion_sword.one"),
                Component.translatable("tooltip.champion-swords.champion_sword.two")
        );
    }

    @Override
    public int getDurabilityCost() {
        return 0;
    }
}
