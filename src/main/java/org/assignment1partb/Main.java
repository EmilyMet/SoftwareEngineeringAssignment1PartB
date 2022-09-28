package org.assignment1partb;

import org.example.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.example.Module;
import org.joda.time.DateTime;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John Smith", LocalDate.of(2002, Month.APRIL, 18), 20947683);
        Student s2 = new Student("Grace Bohan", LocalDate.of(2003, Month.OCTOBER, 25), 65938571);
        Student s3 = new Student("Michael Dooley", LocalDate.of(2000, Month.DECEMBER, 6), 20947683);
        Student s4 = new Student("Sarah Sweeney", LocalDate.of(1998, Month.FEBRUARY, 12), 62846372);
        Student s5 = new Student("Simon Connor", LocalDate.of(2000, Month.MARCH, 9), 98275623);

        ArrayList<Student> allStudents = new ArrayList<>();
        allStudents.add(s1);
        allStudents.add(s2);
        allStudents.add(s3);
        allStudents.add(s4);
        allStudents.add(s5);

        Lecturer l1 = new Lecturer("Daniel Lee", LocalDate.of(1992, Month.SEPTEMBER, 11), 729462);
        Lecturer l2 = new Lecturer("Anna Maloney", LocalDate.of(1984, Month.MAY, 26), 96354792);
        Lecturer l3 = new Lecturer("Jacob Gray", LocalDate.of(1986, Month.NOVEMBER, 5), 15375903);

        org.example.Module m1 = new org.example.Module("Programming 3","CT425", "Daniel Lee");
        org.example.Module m2 = new org.example.Module("Database Systems","CT393", "Anna Maloney");
        org.example.Module m3 = new org.example.Module("Machine Learning","CT214", "Jacob Gray");

        s1.addModule(m1);
        s1.addModule(m2);
        s2.addModule(m2);
        s2.addModule(m3);
        s3.addModule(m1);
        s3.addModule(m3);
        s4.addModule(m1);
        s4.addModule(m2);
        s5.addModule(m2);
        s5.addModule(m3);

        ArrayList<CourseProgramme> allCourses = new ArrayList<>();
        CourseProgramme cp1 = new CourseProgramme("CS & IT",new DateTime(2021, 9, 1,0,0,0), new DateTime(2022,6,1,0,0,0));
        CourseProgramme cp2 = new CourseProgramme("ECE",new DateTime(2021, 9, 6,0,0,0), new DateTime(2022,7,1,0,0,0));
        allCourses.add(cp1);
        allCourses.add(cp2);

        cp1.addModule(m1);
        cp1.addModule(m2);
        cp2.addModule(m2);
        cp2.addModule(m3);

        s1.addCourses(cp1);
        s2.addCourses(cp2);
        s2.addCourses(cp1);
        s3.addCourses(cp2);
        s4.addCourses(cp1);
        s5.addCourses(cp1);
        s5.addCourses(cp2);

        //Prints info on all Courses
        ArrayList<Module> module = new ArrayList<>();
        System.out.println("Courses:");
        for(CourseProgramme cp : allCourses) {
            module = cp.getModules();
            System.out.println("-----------------------------");
            System.out.println("Modules in course: " +cp.getName());
            for (Module m : module) {
                System.out.println(m.getName());
            }
        }

        //Prints info on all students
        ArrayList<CourseProgramme> sCourses = new ArrayList<>();
        System.out.println("\nStudents:");
        for(Student s : allStudents) {
            System.out.println("-----------------------------");
            System.out.println("Student Username: "+ s.getUsername());
            System.out.println("Student's course(s): ");
            sCourses = s.getCourses();
            for(CourseProgramme c : sCourses){
                System.out.println(c.getName());
            }
            module = s.getModules();
            System.out.println("\nStudent's modules: ");
            for (Module m : module) {
                System.out.println(m.getName());
            }
        }

    }

}
