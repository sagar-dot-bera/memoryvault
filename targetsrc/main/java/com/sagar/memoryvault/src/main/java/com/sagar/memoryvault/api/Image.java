package com.sagar.memoryvault.api;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Image associated with a memory.
 */

@Schema(name = "Image", description = "Image associated with a memory.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-07T23:32:26.882419700+05:30[Asia/Calcutta]")
public class Image {

  private URI url;

  private String caption;

  private Integer width;

  private Integer height;

  public Image() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Image(URI url) {
    this.url = url;
  }

  public Image url(URI url) {
    this.url = url;
    return this;
  }

  /**
   * Publicly accessible image URL.
   * @return url
  */
  @NotNull @Valid 
  @Schema(name = "url", example = "https://cdn.example.com/memories/mem_8f3a21c9/photo1.jpg", description = "Publicly accessible image URL.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("url")
  public URI getUrl() {
    return url;
  }

  public void setUrl(URI url) {
    this.url = url;
  }

  public Image caption(String caption) {
    this.caption = caption;
    return this;
  }

  /**
   * Optional caption for the image.
   * @return caption
  */
  
  @Schema(name = "caption", example = "Team lunch on my first day", description = "Optional caption for the image.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("caption")
  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public Image width(Integer width) {
    this.width = width;
    return this;
  }

  /**
   * Get width
   * @return width
  */
  
  @Schema(name = "width", example = "1024", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("width")
  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Image height(Integer height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * @return height
  */
  
  @Schema(name = "height", example = "768", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("height")
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Image image = (Image) o;
    return Objects.equals(this.url, image.url) &&
        Objects.equals(this.caption, image.caption) &&
        Objects.equals(this.width, image.width) &&
        Objects.equals(this.height, image.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, caption, width, height);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Image {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    caption: ").append(toIndentedString(caption)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
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

