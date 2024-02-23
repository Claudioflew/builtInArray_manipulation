// Student name: Koichi Nakata (ID: knakata595)

package org.example;

public class Assignment5 {
    public static void main(String[] args) {

        Course myCourse = new Course("COMSC255 Programming with Java", "Laura Lo");

        myCourse.addStudent("Koichi Nakata");
        myCourse.addStudent("Victor Palacios");
        myCourse.addStudent("Charlie Puth");
        myCourse.addStudent("Sam Smith");
        myCourse.addStudent("Fumio Kishida");

        String[] studentList = {"Doraemon", "Dorami-chan", "Kiteretsu", "Korosuke", "Simon's cat",
                                "Kirby", "Snorlax", "Pikachu", "Raichu", "Winnie the Pooh",
                                "Yui Matsuo", "Fumie Komaya", "Mio Kuramochi", "Moe Kodera", "Koji Narematsu"};
        myCourse.addStudentList(studentList);

        myCourse.dropStudent("Doraemon");
        myCourse.dropStudent("Kiteretsu");
        myCourse.dropStudent("Simon cat");
        myCourse.dropStudent("Simon's cat");

        myCourse.addStudent("Dokodemo-door");
        myCourse.addStudent("Takecopter");

        System.out.println();
        myCourse.print();

        System.out.println("\nCourse information after calling clear():\n");
        myCourse.clear();
        myCourse.print();

    }
}