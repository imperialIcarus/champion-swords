package net.icarus.championswords.datagen.villager;

import net.icarus.championswords.ChampionSwords;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.trading.VillagerTrade;

public class ModVillagerTrades {


    public static void bootstrap(final BootstrapContext<VillagerTrade> context) {
        var items = context.lookup(Registries.ITEM);
        var enchantments = context.lookup(Registries.ENCHANTMENT);





    }
    private static ResourceKey<VillagerTrade> createKey(final String id) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(ChampionSwords.MOD_ID, id));
    }

}
