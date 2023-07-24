package net.dodabyte.magicalbloom.datagen;

import net.dodabyte.magicalbloom.MagicalBloom;
import net.dodabyte.magicalbloom.block.BlocksManager;
import net.dodabyte.magicalbloom.item.ItemsManager;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class CustomRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CustomRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ItemsManager.MAGIC_CRYSTAL.get(),
                RecipeCategory.MISC, BlocksManager.MAGIC_CRYSTAL_BLOCK.get());
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                  RecipeCategory pUnpackedCategory, ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory, ItemLike pPacked) {
        nineBlockStorageRecipes(pFinishedRecipeConsumer, pUnpackedCategory, pUnpacked, pPackedCategory, pPacked,
                getSimpleRecipeName(pPacked), (String)null, getSimpleRecipeName(pUnpacked), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                  RecipeCategory pUnpackedCategory, ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory, ItemLike pPacked, String pPackedName,
                                                  @Nullable String pPackedGroup, String pUnpackedName,
                                                  @Nullable String pUnpackedGroup) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9).requires(pPacked).
                group(pUnpackedGroup).unlockedBy(getHasName(pPacked), has(pPacked)).
                save(pFinishedRecipeConsumer, new ResourceLocation(MagicalBloom.MOD_ID, pUnpackedName));
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked).
                pattern("###").pattern("###").pattern("###").
                group(pPackedGroup).unlockedBy(getHasName(pUnpacked), has(pUnpacked)).
                save(pFinishedRecipeConsumer, new ResourceLocation(MagicalBloom.MOD_ID, pPackedName));
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme,
                                      String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                     RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                     float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience,
                    pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).
                    save(pFinishedRecipeConsumer, new ResourceLocation(MagicalBloom.MOD_ID, getItemName(pResult))
                            + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
