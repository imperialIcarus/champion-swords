package net.icarus.championswords.datagen.villager;

import net.icarus.championswords.ChampionSwords;
import net.icarus.championswords.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;

public class ModVillagerTrades {

    public static final ResourceKey<VillagerTrade> WEAPONSMITH_5_EMERALD_UNDYING_HANDLE = createKey("weaponsmith/5/emerald_undying_handle");

    public static void bootstrap(final BootstrapContext<VillagerTrade> context) {
        var items = context.lookup(Registries.ITEM);
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        context.register(WEAPONSMITH_5_EMERALD_UNDYING_HANDLE, VillagerTrade.builder(new TradeCost(Items.EMERALD, 64), new TradeCost(Items.EMERALD, 64), new ItemStackTemplate(ModItems.UNDYING_HANDLE), 1, 100, 0.05f).build());





    }
    private static ResourceKey<VillagerTrade> createKey(final String id) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(ChampionSwords.MOD_ID, id));
    }

}
