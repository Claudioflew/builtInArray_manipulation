// Student name: Koichi Nakata (ID: knakata595)

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

        System.out.printf("(+)%s was added into %s\n", student, getCourseName());
    }

    public void addStudentList(String[] studentList) {
        for (int i = 0; i < studentList.length; i++) {
            addStudent(studentList[i]);
        }
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

                System.out.printf("(-)%s was dropped from %s\n", student, getCourseName());
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

    public void print() {
        System.out.printf("Course name: %s\n", getCourseName());
        System.out.printf("Instructor name: %s\n", getInstructor());
        System.out.printf("There are %d students enrolled.\n", getNumberOfStudents());
        if (getNumberOfStudents() != 0) {
            System.out.println("Students list:");
            for (int i = 0; i < getNumberOfStudents(); i++) {
                if (i % 5 == 4 || i == getNumberOfStudents()-1) {
                    System.out.printf("%s\n", getStudents()[i]);
                } else {
                    System.out.printf("%s, ", getStudents()[i]);
                }
            }
        }
    }

    public void clear() {
        for (int i = 0; i < getNumberOfStudents(); i++) {
            getStudents()[i] = null;
        }
        setNumberOfStudents(0);
    }

}