package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {
    @Test
    public void testNullaryConstructor() {
        Classroom classrm = new Classroom();
        int expected = 30;
        int result = classrm.getStudent().length;
        Assert.assertEquals(expected,result);
    }
    @Test
    public void testConstructorWithMaxSize() {
        int size = 42;
        Classroom cl = new Classroom(size);
        int result = cl.getStudent().length;
        Assert.assertEquals(size,result);
    }
    @Test
    public void testConstructorWithArray() {
        Double[] scores = {90.0,30.5};
        Student s = new Student("","",scores);
        Student t = new Student("","",scores);
        Student u = new Student("","",scores);
        Student[] studs = new Student[3];
        studs[0] = s;
        studs[1] = t;
        studs[2] = u;
        Classroom cl = new Classroom(studs);
        int result = cl.getStudent().length;
        Assert.assertEquals(3,result);
    }
    @Test
    public void testGetAverage() {
        Double[] scores1 = {90.0,30.0};
        Double[] scores2 = {80.0,60.0};
        Student s = new Student("","",scores1);
        Student t = new Student("","",scores2);
        Student[] studs = new Student[2];
        studs[0] = s;
        studs[1] = t;
        Classroom cl = new Classroom(studs);
        Double result = cl.getAverageExamScore();
        Assert.assertEquals(65.0,result,0.05);
    }

}
