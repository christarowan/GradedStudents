package io.zipcoder;



import java.util.*;

public class Classroom {

    private Student[] students;



    //The class Classroom should define a constructor which takes an argument of an int representative of the maxNumberOfStudents that this Classroom can hold.
    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];

    }

    // The class Classroom should define an additional constructor which takes an argument of Student[] representative of the collection of Student objects this Classroom will store.

    public Classroom(Student[] students) {
        this.students = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
           this.students[i] = students[i];
        }
    }


    //create nullary constructor which initializes the composite students object to be an empty array of 30 Student objects.*/
    public Classroom() {
        this(30);
    }

    //Define a getter which returns the composite students object.
    public Student[] getStudent() {
        return students;
    }


    //Define a getter which returns the sum of all exam averages divided by the number of students.
    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].getAverageExamScore();
        }
        Double average = sum / students.length;
        return average;
    }


    //   Define a method which uses a Student parameter to add a Student object to the composite students list.
    public void addStudent(Student student) {
        //   array to an ArrayList<Student>
        ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(students));

        // Add the Student object
        studentList.add(student);

        //  ArrayList<Student> back to array
        this.students = studentList.toArray(new Student[studentList.size()]);
    }


    // The class Classroom should define a method which uses a firstName and lastName parameter to identify and remove the respective student from composite students object.
    //  Ensure the array is re-ordered after the removal; Null values should be located in the final indices of the array.

    public String removeStudent(String firstName, String lastName) {

        //find student in the array at index
        int indexToRemove = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getFirstName().equals(firstName)
                    && students[i].getLastName().equals(lastName)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove == -1) {
            return "not found";
        }

        // Removes Student at index and re-orders the array
        students[indexToRemove] = null;
        for (int i = indexToRemove; i < students.length - 1; i++) {
            students[i] = students[i + 1];
        }
        students[students.length - 1] = null;

        return "removed";
    }
    //The class Classroom should define a method getStudentsByScore() which returns an array representation of Student objects sorted in descending order by score.
    // If two students have the same class average, order them lexigraphically.

    public Student[] getStudentsByScore() {
        Arrays.sort(students);
        return students;
    }

    /* he class Classroom should define a method getGradeBook() which returns a mapping of Student objects to a respective letter grade determined by creating a grading curve such that
    An A is awarded to students whose class average is in the upper 10th percentile.
    A B is awarded to students whose class average falls between the upper 11th and 29th percentile.
    A C is awarded to students whose class average falls between the upper 30th and 50th percentile.
    A D is awarded to students whose class average falls between the lower 51st and 89th percentile.
    An F is awarded to students whose class average is in the lower 11th percentile. */

    public Map<Student, String> getGradeBook(){

        Map<Student, String> gradeBook = new HashMap<>();



        // sort students by score using Comparator again
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if (s1.getAverageExamScore() == s2.getAverageExamScore()) {
                   return s1.getFirstName().compareTo(s2.getFirstName());
                }
                return Double.compare(s2.getAverageExamScore(), s1.getAverageExamScore());
           }
        });

        // get percentiles
        int n = students.length;
        int upper10th = (int) Math.ceil(0.1 * n);
        int upper11th = (int) Math.ceil(0.11 * n);
        int upper29th = (int) Math.ceil(0.29 * n);
        int upper30th = (int) Math.ceil(0.3 * n);
        int upper50th = (int) Math.ceil(0.5 * n);
        int lower11th = (int) Math.floor(0.11 * n);
        int lower51st = (int) Math.floor(0.51 * n);

        // get grades based on percentiles
        for (int i = 0; i < n; i++) {
            Student student = students[i];
            double percentile = (double) (i + 1) / n;

            if (percentile <= 0.1) {
                gradeBook.put(student, "A");
            } else if (percentile <= 0.29) {
                gradeBook.put(student, "B");
            } else if (percentile <= 0.5) {
                gradeBook.put(student, "C");
            } else if (percentile <= 0.89) {
                gradeBook.put(student, "D");
            } else {
                gradeBook.put(student, "F");
            }
        }

        return gradeBook;
    }
}






















