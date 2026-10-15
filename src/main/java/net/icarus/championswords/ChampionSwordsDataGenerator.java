package net.icarus.championswords;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.icarus.championswords.datagen.*;
import net.icarus.championswords.datagen.villager.ModVillagerTradeTags;
import net.icarus.championswords.datagen.villager.ModVillagerTrades;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class ChampionSwordsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModAdvancementsProvider::new);

		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModVillagerTradeTags::new);

		pack.addProvider(ModRegistryDataProvider::new);

	}
	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {

		registryBuilder.add(Registries.VILLAGER_TRADE, ModVillagerTrades::bootstrap);
	}
}
