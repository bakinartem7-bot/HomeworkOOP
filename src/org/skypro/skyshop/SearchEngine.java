package org.skypro.skyshop;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count = 0;

    SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count++] = searchable;
        }
    }

    Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable item : searchables) {
            if (item == null) continue;
            if (item.getSearchTerm().contains(query)) {
                results[resultCount++] = item;
                if (resultCount == 5) break;
            }
        }

        return results;
    }
}