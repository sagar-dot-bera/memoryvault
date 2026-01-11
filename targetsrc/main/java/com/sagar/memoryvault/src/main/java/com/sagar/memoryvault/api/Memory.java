package com.sagar.memoryvault.api;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sagar.memoryvault.api.Image;
import com.sagar.memoryvault.api.Mood;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Memory
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T23:32:26.882419700+05:30[Asia/Calcutta]")
public class Memory {

  private String id;

  private String title;

  private String description;

  private Mood mood;

  @Valid
  private List<String> tags;

  @Valid
  private List<@Valid Image> images;

  public Memory() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Memory(String id, String title, String description, Mood mood) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.mood = mood;
  }

  public Memory id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique id for the memory
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "123sdgt1315", description = "Unique id for the memory", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Memory title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Short title for the memory
   * @return title
  */
  @NotNull 
  @Schema(name = "title", example = "First Day at New Job", description = "Short title for the memory", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Memory description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Detailed description of memory
   * @return description
  */
  @NotNull 
  @Schema(name = "description", example = "Started my new role as a backend developer and met the team.", description = "Detailed description of memory", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Memory mood(Mood mood) {
    this.mood = mood;
    return this;
  }

  /**
   * Get mood
   * @return mood
  */
  @NotNull @Valid 
  @Schema(name = "mood", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mood")
  public Mood getMood() {
    return mood;
  }

  public void setMood(Mood mood) {
    this.mood = mood;
  }

  public Memory tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Memory addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Optional labels used for categorizing or searching memories.
   * @return tags
  */
  
  @Schema(name = "tags", description = "Optional labels used for categorizing or searching memories.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tags")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Memory images(List<@Valid Image> images) {
    this.images = images;
    return this;
  }

  public Memory addImagesItem(Image imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<>();
    }
    this.images.add(imagesItem);
    return this;
  }

  /**
   * 0 or more images associated with memory
   * @return images
  */
  @Valid 
  @Schema(name = "images", description = "0 or more images associated with memory", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("images")
  public List<@Valid Image> getImages() {
    return images;
  }

  public void setImages(List<@Valid Image> images) {
    this.images = images;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Memory memory = (Memory) o;
    return Objects.equals(this.id, memory.id) &&
        Objects.equals(this.title, memory.title) &&
        Objects.equals(this.description, memory.description) &&
        Objects.equals(this.mood, memory.mood) &&
        Objects.equals(this.tags, memory.tags) &&
        Objects.equals(this.images, memory.images);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, mood, tags, images);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Memory {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    mood: ").append(toIndentedString(mood)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

