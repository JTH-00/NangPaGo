package com.mars.app.domain.recipe.dto;

import com.mars.common.model.recipe.RecipeEs;
import lombok.Builder;
import java.util.List;

@Builder
public record RecipeEsResponseDto(
    String id,
    String name,
    String highlightedName,
    String recipeImageUrl,
    int likeCount,
    int commentCount,
    List<String> ingredients,
    List<String> ingredientsTag,
    List<String> ingredientsDisplayTag,
    float matchScore
) {
    public static RecipeEsResponseDto of(RecipeEs recipeEs,
                                         String highlightedName,
                                         int likeCount,
                                         int commentCount,
                                         float score) {
        return RecipeEsResponseDto.builder()
            .id(recipeEs.getId())
            .name(recipeEs.getName())
            .highlightedName(highlightedName)
            .recipeImageUrl(recipeEs.getRecipeImageUrl())
            .likeCount(likeCount)
            .commentCount(commentCount)
            .ingredients(recipeEs.getIngredients())
            .ingredientsTag(recipeEs.getIngredientsTag())
            .ingredientsDisplayTag(recipeEs.getIngredientsDisplayTag())
            .matchScore(score)
            .build();
    }
}
