package net.icarus.championswords.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.icarus.championswords.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider { // Provides the recipes
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, BootstrapContext<Recipe<?>> recipeContext, BootstrapContext<Advancement> advancementContext) {
        return new RecipeProvider(recipeContext, advancementContext) {
            @Override
            public void buildRecipes() {
                // Uses HasMap to make Sword-To-Handle/Handle-To-Sword Recipes

                HashMap<Item, Item> CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP = new HashMap<>();

                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.ECHOES_SWORD, ModItems.ECHOES_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.UNDYING_SWORD, ModItems.UNDYING_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.ELDER_SWORD, ModItems.ELDER_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.TRIALS_SWORD, ModItems.TRIALS_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.HERO_SWORD, ModItems.HERO_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.ASHES_SWORD, ModItems.ASHES_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.BLAZING_SWORD, ModItems.BLAZING_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.BRUTE_SWORD, ModItems.BRUTE_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.SOULS_SWORD, ModItems.SOULS_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.INFERNO_SWORD, ModItems.INFERNO_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.CRYSTALS_SWORD, ModItems.CRYSTALS_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.EYE_SWORD, ModItems.EYE_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.SHULKER_SWORD, ModItems.SHULKER_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.DRAGON_SWORD, ModItems.DRAGON_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.VOID_SWORD, ModItems.VOID_HANDLE);
                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.put(ModItems.CHAMPION_SWORD, ModItems.CHAMPION_HANDLE);

                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.forEach((sword, handle) ->
                        shapeless(RecipeCategory.COMBAT, handle)
                        .requires(sword)
                        .unlockedBy(getHasName(sword), has(sword))
                        .save(output));

                CHAMPION_SWORDS_HANDLE_TO_SWORD_MAP.forEach((sword, handle) ->
                        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(Items.DIAMOND_SWORD),
                        Ingredient.of(handle),
                        RecipeCategory.COMBAT,
                        sword)
                                .unlocks(getHasName(Items.DIAMOND_SWORD), has(Items.DIAMOND_SWORD))
                                .unlocks(getHasName(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                                .unlocks(getHasName(handle), has(handle))
                                .save(output, getItemName(sword) + "_smithing")
                );
                
                // Merging Recipes
                shapeless(RecipeCategory.COMBAT, ModItems.HERO_HANDLE)
                        .requires(ModItems.ECHOES_HANDLE)
                        .requires(ModItems.ELDER_HANDLE)
                        .requires(ModItems.TRIALS_HANDLE)
                        .requires(ModItems.UNDYING_HANDLE)
                        .unlockedBy(getHasName(ModItems.ECHOES_HANDLE), has(ModItems.ECHOES_HANDLE))
                        .unlockedBy(getHasName(ModItems.ELDER_HANDLE), has(ModItems.ELDER_HANDLE))
                        .unlockedBy(getHasName(ModItems.TRIALS_HANDLE), has(ModItems.TRIALS_HANDLE))
                        .unlockedBy(getHasName(ModItems.UNDYING_HANDLE), has(ModItems.UNDYING_HANDLE))
                        .save(output, "hero_handle_from_merging");

                shapeless(RecipeCategory.COMBAT, ModItems.INFERNO_HANDLE)
                        .requires(ModItems.BLAZING_HANDLE)
                        .requires(ModItems.BRUTE_HANDLE)
                        .requires(ModItems.ASHES_HANDLE)
                        .requires(ModItems.SOULS_HANDLE)
                        .unlockedBy(getHasName(ModItems.BLAZING_HANDLE), has(ModItems.BLAZING_HANDLE))
                        .unlockedBy(getHasName(ModItems.BRUTE_HANDLE), has(ModItems.BRUTE_HANDLE))
                        .unlockedBy(getHasName(ModItems.ASHES_HANDLE), has(ModItems.ASHES_HANDLE))
                        .unlockedBy(getHasName(ModItems.SOULS_HANDLE), has(ModItems.SOULS_HANDLE))
                        .save(output, "inferno_handle_from_merging");

                shapeless(RecipeCategory.COMBAT, ModItems.VOID_HANDLE)
                        .requires(ModItems.SHULKER_HANDLE)
                        .requires(ModItems.EYE_HANDLE)
                        .requires(ModItems.DRAGON_HANDLE)
                        .requires(ModItems.CRYSTALS_HANDLE)
                        .unlockedBy(getHasName(ModItems.SHULKER_HANDLE), has(ModItems.SHULKER_HANDLE))
                        .unlockedBy(getHasName(ModItems.EYE_HANDLE), has(ModItems.EYE_HANDLE))
                        .unlockedBy(getHasName(ModItems.DRAGON_HANDLE), has(ModItems.DRAGON_HANDLE))
                        .unlockedBy(getHasName(ModItems.CRYSTALS_HANDLE), has(ModItems.CRYSTALS_HANDLE))
                        .save(output, "void_handle_from_merging");

                shapeless(RecipeCategory.COMBAT, ModItems.CHAMPION_HANDLE)
                        .requires(ModItems.VOID_HANDLE)
                        .requires(ModItems.INFERNO_HANDLE)
                        .requires(ModItems.HERO_HANDLE)
                        .unlockedBy(getHasName(ModItems.VOID_HANDLE), has(ModItems.VOID_HANDLE))
                        .unlockedBy(getHasName(ModItems.INFERNO_HANDLE), has(ModItems.INFERNO_HANDLE))
                        .unlockedBy(getHasName(ModItems.HERO_HANDLE), has(ModItems.HERO_HANDLE))
                        .save(output, "champion_handle_from_merging");
                
            }
            };
        }

}

