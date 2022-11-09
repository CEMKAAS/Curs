import java.util.*;

public class MaxCategory {
    private Map<String, Integer> ages = new HashMap<>();
    private ArrayList<MaxTime> arraysDays = new ArrayList<>();
    private Map<String, Integer> agesDays = new HashMap<>();

    public void People(String category1, Integer sum1) {
        if (ages.get(category1) == null) {
            ages.put(category1, sum1);
        } else {
            int sum2 = ages.get(category1) + sum1;
            ages.put(category1, sum2);
//            System.out.println(ages);
        }

        Collection<String> collection = ages.keySet();

        String maxtitle = ages.entrySet().stream()
                .filter(entry -> Collections.max(ages.values()).equals(entry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);

//        map.keySet()
//                .stream()
//                .filter(key -> value.equals(map.get(key)))
//                .findFirst().get();

//        System.out.println(maxtitle + " " + Collections.max(ages.values()));
    }

    public void People2(String category1, String title, String data2, Integer sum1) {
        MaxTime category = new MaxTime(title, data2, sum1);


        if (agesDays.get(category1) == null) {
            agesDays.put(category1, sum1);
        } else {
            int sum2 = agesDays.get(category1) + sum1;
            agesDays.put(category1, sum2);
//            System.out.println(agesDays);
        }

        String maxtitle = agesDays.entrySet().stream()
                .filter(entry -> Collections.max(agesDays.values()).equals(entry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(maxtitle + " " + Collections.max(agesDays.values()));
        arraysDays.add(new MaxTime(maxtitle, data2, Collections.max(agesDays.values())));

        Optional<MaxTime> results = arraysDays.stream()
                .filter(f -> f.getDate() == data2)
                .max(Comparator.comparing(u -> u.getSum()));


        results.ifPresentOrElse(System.out::println, () -> System.out.println("sd"));
        Integer string = results.get().getSum();

        System.out.println(string);
        System.out.println(results.get().getDate());

    }
}