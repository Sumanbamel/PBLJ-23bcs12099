import java.util.ArrayList;
import java.util.Collections;

class EmptyStudentListException extends Exception {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

public class StudentList {
    private ArrayList<String> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(String name) {
        students.add(name);
    }

    public void removeStudent(String name) {
        if (students.contains(name)) {
            students.remove(name);
            System.out.println("Removed: " + name);
        } else {
            System.out.println(name + " not found in the list!");
        }
    }

    public void displayStudents() throws EmptyStudentListException {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("Student list is empty!");
        }
        Collections.sort(students);
        System.out.println("Sorted names: " + students);
    }

    public static void main(String[] args) {
        StudentList list = new StudentList();

        System.out.println("Adding names: Alice, Bob, Charlie");
        list.addStudent("Alice");
        list.addStudent("Bob");
        list.addStudent("Charlie");

        try {
            list.displayStudents();
        } catch (EmptyStudentListException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nRemoving Bob...");
        list.removeStudent("Bob");

        try {
            list.displayStudents();
        } catch (EmptyStudentListException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAttempting to display empty list...");
        list.removeStudent("Alice");
        list.removeStudent("Charlie");

        try {
            list.displayStudents();
        } catch (EmptyStudentListException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
