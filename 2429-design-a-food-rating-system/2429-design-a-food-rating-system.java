class FoodRatings {
    private Map<String, Integer> foodToRating;
    private Map<String, String> foodToCuisine;
    private Map<String, TreeSet<FoodEntry>> cuisineFoods;
    private static class FoodEntry {
        int rating;
        String name;
        FoodEntry(int rating, String name) {
            this.rating = rating;
            this.name = name;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof FoodEntry)) return false;
            FoodEntry that = (FoodEntry) o;
            return rating == that.rating && name.equals(that.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(rating, name);
        }
    }
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        cuisineFoods = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rate = ratings[i];
            foodToRating.put(food, rate);
            foodToCuisine.put(food, cuisine);
            cuisineFoods.computeIfAbsent(cuisine, c -> new TreeSet<>(
                (a, b) -> {
                    if (a.rating != b.rating) {
                        return Integer.compare(b.rating, a.rating);
                    }
                    return a.name.compareTo(b.name);
                }
            ));
            cuisineFoods.get(cuisine).add(new FoodEntry(rate, food));
        }
    }
    public void changeRating(String food, int newRating) {
        int oldRating = foodToRating.get(food);
        String cuisine = foodToCuisine.get(food);
        TreeSet<FoodEntry> set = cuisineFoods.get(cuisine);
        set.remove(new FoodEntry(oldRating, food));
        FoodEntry newEntry = new FoodEntry(newRating, food);
        set.add(newEntry);
        foodToRating.put(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        TreeSet<FoodEntry> set = cuisineFoods.get(cuisine);
        return set.first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */