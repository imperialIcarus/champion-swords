package net.icarus.championswords.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.icarus.championswords.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        for (ItemLike itemLike : ModItems.CHAMPION_SWORDS_HANDLES) {
            itemModelGenerators.generateFlatItem((Item) itemLike, ModelTemplates.FLAT_ITEM);
        }
        for (ItemLike itemLike : ModItems.CHAMPION_SWORDS_SWORDS) {
            itemModelGenerators.generateFlatItem((Item) itemLike, ModelTemplates.FLAT_HANDHELD_ITEM);
        }
    }
}
