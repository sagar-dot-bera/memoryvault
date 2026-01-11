package com.sagar.memoryvault.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photo_id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "memory_id", nullable = false)
    private Memory memory;

    @NotNull
    @Column(name = "uri", nullable = false, length = Integer.MAX_VALUE)
    private String uri;

    @Column(name = "caption", length = Integer.MAX_VALUE)
    private String caption;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

}