package org.skypro.skyshop;


import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        Comparator<Searchable> comparator = (a, b) -> {
            int lenDiff = Integer.compare(b.getName().length(), a.getName().length());
            if (lenDiff != 0) {
                return lenDiff;
            }
            return a.getName().compareTo(b.getName());
        };

        Set<Searchable> results = new TreeSet<>(comparator);
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>(); // TreeMap сортирует по ключу

        for (Searchable item : searchables) {
            if (item.getSearchTerm().contains(query)) {
                results.put(item.getName(), item);
            }
        }

        String[] keywords = query.toLowerCase().split("[\\s\\p{Punct}]+");

        return Arrays.stream(keywords)
                .filter(keyword -> !keyword.isEmpty())
                .filter(index::containsKey)
                .flatMap(keyword -> index.get(keyword).stream())
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(getResultComparator())
                ));
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        if (query == null || query.trim().isEmpty()) {
            throw new BestResultNotFound("Пустой запрос не допускается");
        }

        Set<Searchable> candidates = search(query);

        if (candidates.isEmpty()) {
            throw new BestResultNotFound("Нет совпадений для запроса '" + query + "'");
        }

        List<Searchable> perfectMatches = candidates.stream()
                .filter(item -> {
                    String repr = item.getStringRepresentation().toLowerCase();
                    return Arrays.stream(query.toLowerCase().split("[\\s\\p{Punct}]+"))
                            .allMatch(repr::contains);
                })
                .toList();

        if (!perfectMatches.isEmpty()) {
            return perfectMatches.stream()
                    .min(getResultComparator())
                    .orElse(null);
        }

        return candidates.stream()
                .max(Comparator.comparingInt(item -> {
                    String repr = item.getStringRepresentation().toLowerCase();
                    return (int) Arrays.stream(query.toLowerCase().split("[\\s\\p{Punct}]+"))
                            .filter(repr::contains)
                            .count();
                }))
                .orElse(null);
    }

    private Comparator<Searchable> getResultComparator() {
        return (a, b) -> {
            int lenDiff = Integer.compare(
                    b.getStringRepresentation().length(),
                    a.getStringRepresentation().length()
            );
            if (lenDiff != 0) return lenDiff;
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
