package net.icarus.championswords;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.icarus.championswords.creativemodtab.ModCreativeModeTabs;
import net.icarus.championswords.item.ModItems;
import net.icarus.championswords.loot.ModLootTableModifiers;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChampionSwords implements ModInitializer {
	public static final String MOD_ID = "champion-swords";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();
		LootTableEvents.MODIFY.register(ModLootTableModifiers::modifyLootTables);

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
