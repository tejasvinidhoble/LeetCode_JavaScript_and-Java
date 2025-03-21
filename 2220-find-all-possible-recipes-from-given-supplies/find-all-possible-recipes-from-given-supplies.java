class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));

        // Initialize graph and in-degree map
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); // Number of required ingredients
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Processable queue
        Queue<String> queue = new LinkedList<>(available);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String ingredient = queue.poll();
            if (inDegree.containsKey(ingredient) && inDegree.get(ingredient) == 0) {
                result.add(ingredient); // Recipe can be prepared
            }
            if (!graph.containsKey(ingredient)) continue;

            for (String dependentRecipe : graph.get(ingredient)) {
                inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);
                if (inDegree.get(dependentRecipe) == 0) {
                    queue.offer(dependentRecipe);
                }
            }
        }

        return result;
    }
}