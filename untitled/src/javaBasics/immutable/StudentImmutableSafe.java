package javaBasics.immutable;

import java.lang.reflect.Field;

public class StudentImmutableSafe {
    private final String name;

    public StudentImmutableSafe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        //Blocks reflection hacks
        System.setSecurityManager(new SecurityManager());
        StudentImmutableSafe student = new StudentImmutableSafe("Alice");
        System.out.println("Student Name: " + student.getName());
        // student.name = "Bob"; // This line would cause a compilation error
        Field field = StudentImmutableSafe.class.getDeclaredField("name");
        field.setAccessible(true);
        try {
            field.set(student, "Bob");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("Student Name after hack: " + student.getName());
    }
}
