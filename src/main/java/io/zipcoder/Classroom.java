package io.zipcoder;





public class Classroom {

    private Student[] students;

//The class Classroom should define a constructor which takes an argument of an int representative of the maxNumberOfStudents that this Classroom can hold.
    public Classroom (int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];

    }

   // The class Classroom should define an additional constructor which takes an argument of Student[] representative of the collection of Student objects this Classroom will store.

    public Classroom(Student[] students) {
        this.students = students;
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
        Double average = sum/students.length;
        return average;
    }



    //   Define a method which uses a Student parameter to add a Student object to the composite students list.
   public void addStudent(Student student) {
      
        return null;}

   // The class Classroom should define a method which uses a firstName and lastName parameter to identify and remove the respective student from composite students object.
  //  Ensure the array is re-ordered after the removal; Null values should be located in the final indices of the array.

    public String removeStudent(String firstName, String lastName) {return null;}

    //The class Classroom should define a method getStudentsByScore() which returns an array representation of Student objects sorted in descending order by score.
   // If two students have the same class average, order them lexigraphically.

    public void getStudentsByScore() {}

   /* he class Classroom should define a method getGradeBook() which returns a mapping of Student objects to a respective letter grade determined by creating a grading curve such that
    An A is awarded to students whose class average is in the upper 10th percentile.
    A B is awarded to students whose class average falls between the upper 11th and 29th percentile.
    A C is awarded to students whose class average falls between the upper 30th and 50th percentile.
    A D is awarded to students whose class average falls between the lower 51st and 89th percentile.
    An F is awarded to students whose class average is in the lower 11th percentile. */

    public void getGradeBook() {}



}






