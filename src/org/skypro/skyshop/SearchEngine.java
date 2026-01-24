package org.skypro.skyshop;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
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
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound("Поисковый запрос пуст или null: '" + search + "'");
        }

        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : searchables) {
            if (item == null) continue;

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
