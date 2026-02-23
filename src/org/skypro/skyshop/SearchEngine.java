package org.skypro.skyshop;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Map<String, Set<Searchable>> index = new HashMap<>();

    public void add(Searchable item) {
        String text = item.getStringRepresentation().toLowerCase();
        String[] words = text.split("[\\s\\p{Punct}]+");

        for (String word : words) {
            if (!word.isEmpty()) {
                index.computeIfAbsent(word, k -> new TreeSet<>(
                        Comparator.comparing(Searchable::getStringRepresentation)
                )).add(item);
            }
        }
    }

    public Set<Searchable> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptySet();
        }

        String[] keywords = query.toLowerCase().split("[\\s\\p{Punct}]+");
        Set<Searchable> results = new TreeSet<>(getResultComparator());


        for (String keyword : keywords) {
            if (!keyword.isEmpty() && index.containsKey(keyword)) {
                results.addAll(index.get(keyword));
            }
        }

        return results;
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        if (query == null || query.trim().isEmpty()) {
            throw new BestResultNotFound("Пустой запрос не допускается");
        }
        String[] keywords = query.toLowerCase().split("[\\s\\p{Punct}]+");
        List<Searchable> candidates = new ArrayList<>();

        Map<Searchable, Integer> matchCount = new HashMap<>();

        for (String keyword : keywords) {
            if (!keyword.isEmpty() && index.containsKey(keyword)) {
                for (Searchable item : index.get(keyword)) {
                    matchCount.put(item, matchCount.getOrDefault(item, 0) + 1);
                    candidates.add(item);
                }
            }
        }

        if (candidates.isEmpty()) {
            throw new BestResultNotFound("Нет совпадений для запроса '" + query + "'");
        }

        List<Searchable> perfectMatches = candidates.stream()
                .filter(item -> matchCount.get(item) == keywords.length)
                .collect(Collectors.toList());

        if (!perfectMatches.isEmpty()) {
            return perfectMatches.stream()
                    .min(getResultComparator())
                    .orElse(null);
        }

        return candidates.stream()
                .max(Comparator.comparingInt(matchCount::get))
                .orElse(null);
    }

    private Comparator<Searchable> getResultComparator() {
        return (a, b) -> {
            int lenDiff = Integer.compare(b.getStringRepresentation().length(), a.getStringRepresentation().length());
            if (lenDiff != 0) {
                return lenDiff;
            }
            return a.getStringRepresentation().compareTo(b.getStringRepresentation());
        };
    }

    public void clear() {
        index.clear();
    }

    public int getIndexSize() {
        return index.size();
    }
}
