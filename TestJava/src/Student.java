// Product: Складний об'єкт
class Student {
    private String name;
    private String surname;
    private University university; // Flyweight
    private StudentState state;    // State

    // Сеттери для Білдера
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setUniversity(University university) { this.university = university; }
    public void setState(StudentState state) { this.state = state; }

    // Метод для зміни стану
    public void changeState(StudentState newState) {
        this.state = newState;
    }

    public void doActivity() {
        System.out.print(name + " " + surname + " (" + university.getName() + ") [" + state + "]: ");
        state.study();
    }
    // Додай цей метод у клас Student
    public void payTuition() {
        state.payTuition();
    }
}

// Abstract Builder
abstract class StudBuilder {
    protected Student student;

    public void createNewStudent() { student = new Student(); }
    public Student getStudent() { return student; }

    public abstract void buildName(String name);
    public abstract void buildSurname(String surname);
    public abstract void buildUniversity(String uniName);
    public abstract void buildInitialState();
}

// Concrete Builder 1: Звичайний студент
class NormalStudBuilder extends StudBuilder {
    @Override
    public void buildName(String name) { student.setName(name); }
    @Override
    public void buildSurname(String surname) { student.setSurname(surname); }
    @Override
    public void buildUniversity(String uniName) {
        // Використовуємо Flyweight Factory
        student.setUniversity(UniversityFactory.getUniversity(uniName));
    }
    @Override
    public void buildInitialState() {
        student.setState(new ActiveState()); // За замовчуванням активний
    }
}

// Director: Керує процесом (Прораб)
class Director {
    private StudBuilder builder;

    public void setBuilder(StudBuilder builder) {
        this.builder = builder;
    }

    public Student constructStudent(String name, String surname, String uniName) {
        builder.createNewStudent();
        builder.buildName(name);
        builder.buildSurname(surname);
        builder.buildUniversity(uniName);
        builder.buildInitialState();
        return builder.getStudent();
    }
}