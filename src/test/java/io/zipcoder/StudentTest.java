package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void testConstructor() {
        Double[] scores = {};
        Student s = new Student("Joe", "Smith", scores);
        assert s instanceof Student;
    }

    @Test
    public void testAddExamScore() {
        Double[] scores = {};
        Student s = new Student("Joe", "Smith", scores);
        s.addExamScore(99.0);
        Assert.assertEquals(s.getAverageExamScore(),99.0,0.5);
    }
    @Test
    public void testSetExamScore() {
        Double[] scores = {};
        Student s = new Student("Joe", "Smith", scores);
        s.addExamScore(99.0);
        s.setExamScore(0,94.0);
        Assert.assertEquals(s.getAverageExamScore(),94.0,0.5);
    }
    @Test
    public void testGetExamScores() {
        Double[] scores = {12.0, 95.5, 87.0};
        Student s = new Student("Joe", "Smith", scores);
        s.addExamScore(75.5);
        s.setExamScore(3, 2);
        String result = s.getExamScores();
        System.out.println(result);
    }

    @Test
    public void testGetAverage() {
        Double[] scores = {10.0, 20.0, 30.0};
        Student s = new Student("Mary","Blige",scores);
        double result = s.getAverageExamScore();
        double expected = 20.0;
        Assert.assertEquals(expected,result,.05);
    }
}