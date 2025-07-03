import java.util.*;

public class RecommendationEngine {
    public static void main(String[] args) {
        Map<String, List<String>> userPreferences = new HashMap<>();
        userPreferences.put("User1", Arrays.asList("Java", "Python", "Machine Learning"));
        userPreferences.put("User2", Arrays.asList("Java", "Web Development", "Spring Boot"));
        userPreferences.put("User3", Arrays.asList("Python", "Data Science", "AI"));

        String targetUser = "User2";
        List<String> recommendations = generateRecommendations(userPreferences, targetUser);

        System.out.println("Recommendations for " + targetUser + ":");
        for (String rec : recommendations) {
            System.out.println("- " + rec);
        }
    }

    public static List<String> generateRecommendations(Map<String, List<String>> userPrefs, String targetUser) {
        Set<String> allItems = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : userPrefs.entrySet()) {
            if (!entry.getKey().equals(targetUser)) {
                allItems.addAll(entry.getValue());
            }
        }
        allItems.removeAll(userPrefs.get(targetUser));
        return new ArrayList<>(allItems);
    }
}
