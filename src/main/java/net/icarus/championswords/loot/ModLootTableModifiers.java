package net.icarus.championswords.loot;

import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.icarus.championswords.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.List;

public class ModLootTableModifiers {
    public static void modifyLootTables(ResourceKey<LootTable> key, FabricLootTableBuilder builder, LootTableSource source, HolderLookup.Provider provider) {
        var enchantments = provider.lookupOrThrow(Registries.ENCHANTMENT);
        // Echoes Handle Drop
        addPoolToLootTable(key, builder, "entities/warden", 1, LootItemRandomChanceCondition.randomChance(1f), List.of(LootItem.lootTableItem(ModItems.ECHOES_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Elder Handle Drop
        addPoolToLootTable(key, builder, "entities/elder_guardian", 1, LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.1f, 0.05f), List.of(LootItem.lootTableItem(ModItems.ELDER_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Trials Handle Drop
        addPoolToLootTable(key, builder, "chests/trial_chambers/reward_ominous_unique", 1, LootItemRandomChanceCondition.randomChance(0.25f), List.of(LootItem.lootTableItem(ModItems.TRIALS_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Ashes Handle Drop
        addPoolToLootTable(key, builder, "entities/wither", 1, LootItemRandomChanceCondition.randomChance(1f), List.of(LootItem.lootTableItem(ModItems.ASHES_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Blazing Handle Drop
        addPoolToLootTable(key, builder, "entities/blaze", 1, LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f), List.of(LootItem.lootTableItem(ModItems.BLAZING_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Brute Handle Drop
        addPoolToLootTable(key, builder, "chests/bastion_treasure", 1, LootItemRandomChanceCondition.randomChance(0.25f), List.of(LootItem.lootTableItem(ModItems.BRUTE_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        addPoolToLootTable(key, builder, "chests/bastion_other", 1, LootItemRandomChanceCondition.randomChance(0.15f), List.of(LootItem.lootTableItem(ModItems.BRUTE_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        addPoolToLootTable(key, builder, "chests/bastion_bridge", 1, LootItemRandomChanceCondition.randomChance(0.15f), List.of(LootItem.lootTableItem(ModItems.BRUTE_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        addPoolToLootTable(key, builder, "chests/bastion_hoglin_stable", 1, LootItemRandomChanceCondition.randomChance(0.15f), List.of(LootItem.lootTableItem(ModItems.BRUTE_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Souls Handle Drop
        addPoolToLootTable(key, builder, "entities/ghast", 1, LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.15f, 0.05f), List.of(LootItem.lootTableItem(ModItems.SOULS_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Eye Handle Drop
        addPoolToLootTable(key, builder, "entities/enderman", 1, LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f), List.of(LootItem.lootTableItem(ModItems.EYE_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Shulker Handle Drop
        addPoolToLootTable(key, builder, "entities/shulker", 1, LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(enchantments, 0.03f, 0.01f), List.of(LootItem.lootTableItem(ModItems.SHULKER_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));
        // Dragon Handle Drop
        addPoolToLootTable(key, builder, "entities/ender_dragon", 1, LootItemRandomChanceCondition.randomChance(1f), List.of(LootItem.lootTableItem(ModItems.DRAGON_HANDLE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))));



    }

    public static void addPoolToLootTable(ResourceKey<LootTable> key, FabricLootTableBuilder builder, String path, int rolls, LootItemCondition.Builder condition, List<? extends UniformContainerBase.Builder<?>> entries) {
        if (key.identifier().equals(Identifier.withDefaultNamespace(path))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(rolls))
                    .when(condition)
                    .addAll((entries));

            builder.pool(poolBuilder.build());
        }
    }
}
