// State Interface
interface StudentState {
    void study();
    void payTuition();
}

// Concrete State 1: На навчанні
class ActiveState implements StudentState {
    @Override
    public void study() {
        System.out.println("Студент відвідує пари.");
    }
    @Override
    public void payTuition() {
        System.out.println("Оплата за семестр прийнята.");
    }
    @Override
    public String toString() { return "Активний"; }
}

// Concrete State 2: Відрахований
class ExpelledState implements StudentState {
    @Override
    public void study() {
        System.out.println("Студент не може вчитися, його відраховано.");
    }
    @Override
    public void payTuition() {
        System.out.println("Немає за що платити.");
    }
    @Override
    public String toString() { return "Відрахований"; }
}