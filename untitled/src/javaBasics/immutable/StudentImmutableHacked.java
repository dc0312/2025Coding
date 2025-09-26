package javaBasics.immutable;

import java.lang.reflect.Field;

public final class StudentImmutableHacked {

    private final String name;

    public StudentImmutableHacked(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        StudentImmutableHacked student = new StudentImmutableHacked("Alice");
        System.out.println("Student Name: " + student.getName());

        Field field = StudentImmutableHacked.class.getDeclaredField("name");
        field.setAccessible(true);
        try {
            field.set(student, "Bob");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("Student Name after hack: " + student.getName());

    }
}
