public class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    private Set<Integer> done = new HashSet<>();      // NEW: replaces clearing preMap
    private List<Integer> order = new ArrayList<>();  // NEW: collect order

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return new int[0];  // cycle → empty array
            }
        }

        // Convert list to int[]
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    private boolean dfs(int crs) {
        if (visiting.contains(crs)) {
            return false;                    // cycle
        }
        if (done.contains(crs)) {
            return true;                     // already processed (memo)
        }

        visiting.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visiting.remove(crs);

        done.add(crs);                       // memo (was: preMap.put(crs, new ArrayList<>())
        order.add(crs);                      // NEW: add AFTER all prereqs done

        return true;
    }
}