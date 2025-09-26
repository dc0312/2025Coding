package javaBasics.immutable;


//1. Make the class final so it cannot be extended
public final class StudentImmutable {
    //2. Make all fields private and final
    private final String name;

    //3. Provide a parameterized constructor to initialize the fields
    public StudentImmutable(String name) {
        this.name = name;
    }

    //4. Do not provide setter methods
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        StudentImmutable student = new StudentImmutable("Alice");
        System.out.println("Student Name: " + student.getName());
        // student.name = "Bob"; // This line would cause a compilation error
    }
}
