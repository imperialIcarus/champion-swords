package net.icarus.championswords.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.icarus.championswords.ChampionSwords;
import net.icarus.championswords.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public ModAdvancementsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);

    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder getDiamondSword = Advancement.Builder.advancement().rootDisplay(
                Items.DIAMOND_SWORD,
                Component.translatable("advancements.champion-swords.get_diamond_sword.title"),
                Component.translatable("advancements.champion-swords.get_diamond_sword.description"),
                Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                AdvancementType.TASK,
                true,
                true,
                false
                )
                .addCriterion("got_diamond_sword", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND_SWORD))
                .save(consumer, ChampionSwords.id("get_diamond_sword"));
        Advancement.Builder.advancement().display(
                ModItems.ECHOES_SWORD,
                Component.translatable("advancements.champion-swords.get_echoes_sword.title"),
                Component.translatable("advancements.champion-swords.get_echoes_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_echoes_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ECHOES_SWORD))
                .save(consumer, ChampionSwords.id("get_echoes_sword"));
        Advancement.Builder.advancement().display(
                ModItems.UNDYING_SWORD,
                Component.translatable("advancements.champion-swords.get_undying_sword.title"),
                Component.translatable("advancements.champion-swords.get_undying_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_undying_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.UNDYING_SWORD))
                .save(consumer, ChampionSwords.id("get_undying_sword"));
        Advancement.Builder.advancement().display(
                ModItems.ELDER_SWORD,
                Component.translatable("advancements.champion-swords.get_elder_sword.title"),
                Component.translatable("advancements.champion-swords.get_elder_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_elder_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ELDER_SWORD))
                .save(consumer, ChampionSwords.id("get_elder_sword"));
        Advancement.Builder.advancement().display(
                ModItems.TRIALS_SWORD,
                Component.translatable("advancements.champion-swords.get_trials_sword.title"),
                Component.translatable("advancements.champion-swords.get_trials_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_trials_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TRIALS_SWORD))
                .save(consumer, ChampionSwords.id("get_trials_sword"));
        Advancement.Builder.advancement().display(
                ModItems.ASHES_SWORD,
                Component.translatable("advancements.champion-swords.get_ashes_sword.title"),
                Component.translatable("advancements.champion-swords.get_ashes_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_ashes_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ASHES_SWORD))
                .save(consumer, ChampionSwords.id("get_ashes_sword"));
        Advancement.Builder.advancement().display(
                ModItems.BLAZING_SWORD,
                Component.translatable("advancements.champion-swords.get_blazing_sword.title"),
                Component.translatable("advancements.champion-swords.get_blazing_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_blazing_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BLAZING_SWORD))
                .save(consumer, ChampionSwords.id("get_blazing_sword"));
        Advancement.Builder.advancement().display(
                ModItems.BRUTE_SWORD,
                Component.translatable("advancements.champion-swords.get_brute_sword.title"),
                Component.translatable("advancements.champion-swords.get_brute_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_brute_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRUTE_SWORD))
                .save(consumer, ChampionSwords.id("get_brute_sword"));
        Advancement.Builder.advancement().display(
                ModItems.SOULS_SWORD,
                Component.translatable("advancements.champion-swords.get_souls_sword.title"),
                Component.translatable("advancements.champion-swords.get_souls_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_souls_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SOULS_SWORD))
                .save(consumer, ChampionSwords.id("get_souls_sword"));
        Advancement.Builder.advancement().display(
                ModItems.EYE_SWORD,
                Component.translatable("advancements.champion-swords.get_eye_sword.title"),
                Component.translatable("advancements.champion-swords.get_eye_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_eye_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EYE_SWORD))
                .save(consumer, ChampionSwords.id("get_eye_sword"));
        Advancement.Builder.advancement().display(
                ModItems.CRYSTALS_SWORD,
                Component.translatable("advancements.champion-swords.get_crystals_sword.title"),
                Component.translatable("advancements.champion-swords.get_crystals_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_crystals_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CRYSTALS_SWORD))
                .save(consumer, ChampionSwords.id("get_crystals_sword"));
        Advancement.Builder.advancement().display(
                ModItems.SHULKER_SWORD,
                Component.translatable("advancements.champion-swords.get_shulker_sword.title"),
                Component.translatable("advancements.champion-swords.get_shulker_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_shulker_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SHULKER_SWORD))
                .save(consumer, ChampionSwords.id("get_shulker_sword"));
        Advancement.Builder.advancement().display(
                ModItems.DRAGON_SWORD,
                Component.translatable("advancements.champion-swords.get_dragon_sword.title"),
                Component.translatable("advancements.champion-swords.get_dragon_sword.description"),
                AdvancementType.GOAL,
                true,
                true,
                false
        )
                .parent(getDiamondSword)
                .addCriterion("got_dragon_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGON_SWORD))
                .save(consumer, ChampionSwords.id("get_dragon_sword"));
        Advancement.Builder.advancement().display(
                        ModItems.HERO_SWORD,
                        Component.translatable("advancements.champion-swords.get_hero_sword.title"),
                        Component.translatable("advancements.champion-swords.get_hero_sword.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .parent(getDiamondSword)
                .addCriterion("got_hero_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HERO_SWORD))
                .save(consumer, ChampionSwords.id("get_hero_sword"));
        Advancement.Builder.advancement().display(
                        ModItems.INFERNO_SWORD,
                        Component.translatable("advancements.champion-swords.get_inferno_sword.title"),
                        Component.translatable("advancements.champion-swords.get_inferno_sword.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .parent(getDiamondSword)
                .addCriterion("got_inferno_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.INFERNO_SWORD))
                .save(consumer, ChampionSwords.id("get_inferno_sword"));
        Advancement.Builder.advancement().display(
                        ModItems.VOID_SWORD,
                        Component.translatable("advancements.champion-swords.get_void_sword.title"),
                        Component.translatable("advancements.champion-swords.get_void_sword.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .parent(getDiamondSword)
                .addCriterion("got_void_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VOID_SWORD))
                .save(consumer, ChampionSwords.id("get_void_sword"));
        Advancement.Builder.advancement().display(
                        ModItems.CHAMPION_SWORD,
                        Component.translatable("advancements.champion-swords.get_champion_sword.title"),
                        Component.translatable("advancements.champion-swords.get_champion_sword.description"),
                        AdvancementType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .parent(getDiamondSword)
                .addCriterion("got_champion_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHAMPION_SWORD))
                .save(consumer, ChampionSwords.id("get_champion_sword"));
    }
}
