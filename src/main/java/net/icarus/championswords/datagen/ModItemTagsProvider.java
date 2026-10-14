package net.icarus.championswords.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.icarus.championswords.item.ModItems;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.getRK(ModItems.ECHOES_SWORD))
                .add(ModItems.getRK(ModItems.UNDYING_SWORD))
                .add(ModItems.getRK(ModItems.ELDER_SWORD))
                .add(ModItems.getRK(ModItems.TRIALS_SWORD))
                .add(ModItems.getRK(ModItems.HERO_SWORD))
                .add(ModItems.getRK(ModItems.ASHES_SWORD))
                .add(ModItems.getRK(ModItems.BLAZING_SWORD))
                .add(ModItems.getRK(ModItems.BRUTE_SWORD))
                .add(ModItems.getRK(ModItems.SOULS_SWORD))
                .add(ModItems.getRK(ModItems.INFERNO_SWORD))
                .add(ModItems.getRK(ModItems.EYE_SWORD))
                .add(ModItems.getRK(ModItems.CRYSTALS_SWORD))
                .add(ModItems.getRK(ModItems.SHULKER_SWORD))
                .add(ModItems.getRK(ModItems.DRAGON_SWORD))
                .add(ModItems.getRK(ModItems.VOID_SWORD))
                .add(ModItems.getRK(ModItems.CHAMPION_SWORD));
    }

}
