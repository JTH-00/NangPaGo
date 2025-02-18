package com.mars.common.model.refrigerator;

import com.mars.common.model.ingredient.Ingredient;
import com.mars.common.model.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "ingredient_id"})}) 
@Entity
public class Refrigerator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public static Refrigerator of(User user, Ingredient ingredient) {
        return Refrigerator.builder()
                .user(user)
                .ingredient(ingredient)
                .build();
    }
}
