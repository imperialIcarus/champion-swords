package net.icarus.championswords.item;

import net.icarus.championswords.ChampionSwords;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial TIER_ONE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            2031,
            9f,
            4f,
            15,
            TagKey.create(Registries.ITEM, ChampionSwords.id("empty_repair_key"))
    );
    public static final ToolMaterial TIER_TWO_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            4061,
            9f,
            8f,
            15,
            TagKey.create(Registries.ITEM, ChampionSwords.id("empty_repair_key"))
    );
    public static final ToolMaterial TIER_THREE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            8122,
            9f,
            20f,
            15,
            TagKey.create(Registries.ITEM, ChampionSwords.id("empty_repair_key"))
    );

}
