package org.example;

public class Course {
    private int capacity = 16;
    private int numberOfStudents = 0;
    private String courseName;
    private String instructor;
    private String[] students = new String[capacity];

    public Course(String courseName) {
        this(courseName, "tba");
    }

    public Course(String courseName, String instructor) {
        this.courseName = courseName;
        setInstructor(instructor);
    }

    public int getCapacity() { return capacity; }
    private void setCapacity(int capacity) {
        if (capacity >= getNumberOfStudents()) {
            this.capacity = capacity;
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setInstructor(String instructor) { this.instructor = instructor; }
    public String getInstructor() { return instructor; }

    public void addStudent(String student) {
        if (getNumberOfStudents() + 1 > getCapacity()) {
            increseSize();
        }
        students[getNumberOfStudents()] = student;
        setNumberOfStudents(getNumberOfStudents()+1);
    }

    public void dropStudent(String student) {
        boolean found = false;
        for (int i = 0; i < getNumberOfStudents(); i++) {
            if (student.equals(getStudents()[i])) {
                found = true;
                int j;
                for (j = i; j < getNumberOfStudents()-1; j++) {
                    getStudents()[j] = getStudents()[j+1];
                }
                getStudents()[j] = null;
                setNumberOfStudents(getNumberOfStudents()-1);
                break;
            }
        }
        if (!found) {
            System.out.printf("Couldn't find %s in the list..\n", student);
        }
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() { return numberOfStudents; }
    private void setNumberOfStudents(int numberOfStudents) {
        if (numberOfStudents >= 0) {
            this.numberOfStudents = numberOfStudents;
        }
    }

    private void increseSize() {
        setCapacity(getCapacity()*2);
        String[] newArray = new String[getCapacity()];
        System.arraycopy(getStudents(), 0, newArray, 0, getStudents().length);
        students = newArray;
    }

}