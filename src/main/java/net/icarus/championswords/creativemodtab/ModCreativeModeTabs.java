package net.icarus.championswords.creativemodtab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.icarus.championswords.ChampionSwords;
import net.icarus.championswords.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class ModCreativeModeTabs {
    public static final CreativeModeTab CHAMPION_SWORDS_CREATIVE_MODE_TAB = register("champion_swords_items",
            Component.translatable("creativemodetab.champion-swords.champion_swords_items"),
            ModItems.ECHOES_SWORD,
            List.of(
                    ModItems.ECHOES_SWORD,
                    ModItems.ECHOES_HANDLE
            ));
    public static void registerModCreativeModeTabs() {
        ChampionSwords.LOGGER.info("Registering Mod Creative Mode Tabs for" + ChampionSwords.MOD_ID);

    }

    public static CreativeModeTab register(String name, Component title, ItemLike icon, List<ItemLike> entries) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(ChampionSwords.MOD_ID, name),
                FabricCreativeModeTab.builder()
                        .title(title)
                        .icon(() -> new ItemStack(icon))
                        .displayItems(((parameters, output) -> {
                            for(ItemLike entry : entries) {
                                output.accept(entry);
                            }
                        }))
                        .build());
    }
}
