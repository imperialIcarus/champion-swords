package net.icarus.championswords.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.icarus.championswords.ChampionSwords;
import net.icarus.championswords.item.advanced.*;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Compostable;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    // Swords
    public static final Item ECHOES_SWORD = registerItem("echoes_sword", EchoesSwordItem::new);
    public static final Item UNDYING_SWORD = registerItem("undying_sword", UndyingSwordItem::new);
    public static final Item ELDER_SWORD = registerItem("elder_sword", ElderSwordItem::new);
    public static final Item TRIALS_SWORD = registerItem("trials_sword", TrialsSwordItem::new);
    public static final Item HERO_SWORD = registerItem("hero_sword", HeroSwordItem::new);
    public static final Item ASHES_SWORD = registerItem("ashes_sword", AshesSwordItem::new);
    public static final Item BLAZING_SWORD = registerItem("blazing_sword", BlazingSwordItem::new);
    public static final Item BRUTE_SWORD = registerItem("brute_sword", BruteSwordItem::new);
    public static final Item SOULS_SWORD = registerItem("souls_sword", SoulsSwordItem::new);
    public static final Item INFERNO_SWORD = registerItem("inferno_sword", InfernoSwordItem::new);
    public static final Item CRYSTALS_SWORD = registerItem("crystals_sword", CrystalsSwordItem::new);
    public static final Item EYE_SWORD = registerItem("eye_sword", EyeSwordItem::new);
    public static final Item SHULKER_SWORD = registerItem("shulker_sword", ShulkerSwordItem::new);
    public static final Item DRAGON_SWORD = registerItem("dragon_sword", DragonSwordItem::new);
    public static final Item VOID_SWORD = registerItem("void_sword", VoidSwordItem::new);
    public static final Item CHAMPION_SWORD = registerItem("champion_sword", ChampionSwordItem::new);
    public static final List<ItemLike> CHAMPION_SWORDS_SWORDS = List.of(ECHOES_SWORD, UNDYING_SWORD, ELDER_SWORD, TRIALS_SWORD, HERO_SWORD, ASHES_SWORD, BLAZING_SWORD, BRUTE_SWORD, SOULS_SWORD, INFERNO_SWORD, CRYSTALS_SWORD, EYE_SWORD, SHULKER_SWORD, DRAGON_SWORD, VOID_SWORD, CHAMPION_SWORD);
    // Handles
    public static final Item ECHOES_HANDLE = registerItem("echoes_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item UNDYING_HANDLE = registerItem("undying_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item ELDER_HANDLE = registerItem("elder_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item TRIALS_HANDLE = registerItem("trials_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item HERO_HANDLE = registerItem("hero_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.RARE)));
    public static final Item ASHES_HANDLE = registerItem("ashes_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item BLAZING_HANDLE = registerItem("blazing_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item BRUTE_HANDLE = registerItem("brute_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item SOULS_HANDLE = registerItem("souls_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item INFERNO_HANDLE = registerItem("inferno_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.RARE)));
    public static final Item CRYSTALS_HANDLE = registerItem("crystals_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item EYE_HANDLE = registerItem("eye_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item SHULKER_HANDLE = registerItem("shulker_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item DRAGON_HANDLE = registerItem("dragon_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final Item VOID_HANDLE = registerItem("void_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.RARE)));
    public static final Item CHAMPION_HANDLE = registerItem("champion_handle", properties -> new Item(properties.stacksTo(1).rarity(Rarity.EPIC)));

    public static final List<ItemLike> CHAMPION_SWORDS_HANDLES = List.of(ECHOES_HANDLE, UNDYING_HANDLE, ELDER_HANDLE, TRIALS_HANDLE, HERO_HANDLE, ASHES_HANDLE, BLAZING_HANDLE, BRUTE_HANDLE, SOULS_HANDLE, INFERNO_HANDLE, CRYSTALS_HANDLE, EYE_HANDLE, SHULKER_HANDLE, DRAGON_HANDLE, VOID_HANDLE, CHAMPION_HANDLE);

    public static final List<ItemLike> CHAMPION_SWORDS_ITEMS = List.of(ECHOES_HANDLE, UNDYING_HANDLE, ELDER_HANDLE, TRIALS_HANDLE, HERO_HANDLE, ASHES_HANDLE, BLAZING_HANDLE, BRUTE_HANDLE, SOULS_HANDLE, INFERNO_HANDLE, CRYSTALS_HANDLE, EYE_HANDLE, SHULKER_HANDLE, DRAGON_HANDLE, VOID_HANDLE, CHAMPION_HANDLE,ECHOES_SWORD, UNDYING_SWORD, ELDER_SWORD, TRIALS_SWORD, HERO_SWORD, ASHES_SWORD, BLAZING_SWORD, BRUTE_SWORD, SOULS_SWORD, INFERNO_SWORD, CRYSTALS_SWORD, EYE_SWORD, SHULKER_SWORD, DRAGON_SWORD, VOID_SWORD, CHAMPION_SWORD);

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ChampionSwords.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ChampionSwords.MOD_ID, name)))));
    }

    public static void registerModItems() {
        ChampionSwords.LOGGER.info("Registering Mod Items for " + ChampionSwords.MOD_ID);
    }

}
