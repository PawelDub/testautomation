package com.jsystems.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Book implements Serializable {
    @JsonProperty("ID")
    public Long id;

    @JsonProperty("Title")
    public String title;

    @JsonProperty("Description")
    public String description;

    @JsonProperty("PageCount")
    public int pageCount;

    @JsonProperty("Excerpt")
    public String excerpt;

    @JsonProperty("PublishDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX")
    public Date publishDate;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", Excerpt='" + excerpt + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
