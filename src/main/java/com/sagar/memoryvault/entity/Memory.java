package com.sagar.memoryvault.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "memories")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memory_id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "tags")
    private List<String> tags;

    @Column(name = "mood", columnDefinition = "mood_enum not null")
    @Convert(converter = MoodAttributeConverter.class)
    private Mood mood;

    public static org.openapitools.model.Mood moodMapper(Mood mood) {
        return switch (mood) {
            case HAPPY -> org.openapitools.model.Mood.HAPPY;
            case SAD -> org.openapitools.model.Mood.SAD;
            case CALM -> org.openapitools.model.Mood.CALM;
            case DARK -> org.openapitools.model.Mood.DARK;
            case ANGRY -> org.openapitools.model.Mood.ANGRY;
            case CHAOTIC -> org.openapitools.model.Mood.CHAOTIC;
            case HOPEFUL -> org.openapitools.model.Mood.HOPEFUL;
            default -> throw new IllegalArgumentException("Invalid mood");
        };
    }

}