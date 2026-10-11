package net.icarus.championswords.loot;

import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.List;

public class ModLootTableModifiers {
    public static void modifyLootTables(ResourceKey<LootTable> key, FabricLootTableBuilder builder, LootTableSource source, HolderLookup.Provider provider) {

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
