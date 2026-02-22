package org.skypro.skyshop;

import java.util.Objects;

public class Article implements Searchable {
    private String name;
    private String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return name + " " + content;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStringRepresentation() {
        return name + " (" + content + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}