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

import java.util.List;

import static net.icarus.championswords.item.ModItems.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        List<ItemLike> CHAMPION_SWORDS_SWORDS_WITH_NORMAL_MODEL = List.of(ECHOES_SWORD, UNDYING_SWORD, ELDER_SWORD, TRIALS_SWORD, HERO_SWORD, ASHES_SWORD, BLAZING_SWORD, BRUTE_SWORD, SOULS_SWORD, INFERNO_SWORD, CRYSTALS_SWORD, EYE_SWORD, SHULKER_SWORD, DRAGON_SWORD, VOID_SWORD);
        itemModelGenerators.declareCustomModelItem(CHAMPION_SWORD);
        for (ItemLike itemLike : ModItems.CHAMPION_SWORDS_HANDLES) {
            itemModelGenerators.generateFlatItem((Item) itemLike, ModelTemplates.FLAT_ITEM);
        }
        for (ItemLike itemLike : CHAMPION_SWORDS_SWORDS_WITH_NORMAL_MODEL) {
            itemModelGenerators.generateFlatItem((Item) itemLike, ModelTemplates.FLAT_HANDHELD_ITEM);
        }
    }
}
