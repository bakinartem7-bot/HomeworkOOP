package org.skypro.skyshop;


import java.util.*;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>(); // TreeMap сортирует по ключу

        for (Searchable item : searchables) {
            if (item.getSearchTerm().contains(query)) {
                results.put(item.getName(), item);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound("Поисковый запрос пуст или null: '" + search + "'");
        }

        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : searchables) {
            String term = item.getSearchTerm();
            int occurrences = countOccurrences(term, search);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено совпадений для запроса: '" + search + "'");
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        if (text == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int subLen = substring.length();

        while (true) {
            int nextIndex = text.indexOf(substring, index);
            if (nextIndex == -1) break;
            count++;
            index = nextIndex + subLen;
        }

        return count;
    }
}