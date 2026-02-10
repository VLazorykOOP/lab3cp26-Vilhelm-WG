import java.util.HashMap;
import java.util.Map;

// Flyweight: Спільний об'єкт (наприклад, Університет)
class University {
    private String name;

    public University(String name) {
        this.name = name;
        System.out.println("Створено новий університет: " + name);
    }

    public String getName() {
        return name;
    }
}

// Flyweight Factory: Керує пулом університетів
class UniversityFactory {
    private static final Map<String, University> universities = new HashMap<>();

    public static University getUniversity(String name) {
        University uni = universities.get(name);
        if (uni == null) {
            uni = new University(name);
            universities.put(name, uni);
        }
        return uni;
    }
}