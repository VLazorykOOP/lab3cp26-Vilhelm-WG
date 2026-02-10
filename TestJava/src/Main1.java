public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        // 1. Створюємо білдер для звичайного студента
        StudBuilder normalBuilder = new NormalStudBuilder();
        director.setBuilder(normalBuilder);

        // 2. Створюємо двох студентів в ОДНОМУ університеті (перевірка Flyweight)
        System.out.println("--- Створення студентів ---");
        Student st1 = director.constructStudent("Іван", "Петренко", "КПІ");
        Student st2 = director.constructStudent("Олена", "Коваль", "КПІ"); // "КПІ" не створиться вдруге
        Student st3 = director.constructStudent("Макс", "Сидорчук", "НАУ"); // Створиться новий об'єкт університету

        System.out.println("\n--- Перевірка роботи ---");
        st1.doActivity();
        st2.doActivity();
        st3.doActivity();

        // 3. Перевірка State (змінюємо стан першого студента)
        System.out.println("\n--- Зміна стану (Івана відраховують) ---");
        st1.changeState(new ExpelledState());
        st1.doActivity(); // Поведінка зміниться
        st1.payTuition(); // Поведінка зміниться
    }
}