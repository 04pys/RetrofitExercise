package com.example.retrofitexercise;

import java.util.List;

public class RealworldArticle {
    public String title;
    public String slug;
    public String body;
    public String createdAt;
    public String updatedAt;
    public List<String> tagList = null;
    public String description;
    public RealworldAuthor rearworldAuthor;
    public Boolean favorited;
    public Integer favoritesCount;
}
