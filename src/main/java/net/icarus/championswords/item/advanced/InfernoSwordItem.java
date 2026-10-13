package net.icarus.championswords.item.advanced;

import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.item.ModToolMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import java.util.List;

public class InfernoSwordItem extends AbstractCustomSwordItem {

    public InfernoSwordItem(Properties properties) {
        super(properties, ModToolMaterials.TIER_TWO_TOOL_MATERIAL, 0);

    }

    @Override
    public InteractionResult doRightClickAbility(Level level, Player player, InteractionHand hand) {
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
        return List.of();
    }

    @Override
    public int getDurabilityCost() {
        return 0;
    }
}
