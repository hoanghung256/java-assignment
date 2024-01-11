/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoang
 */
public class StudentDatabase {
    private List<ITStudent> it_students = new ArrayList<>();
  private List<BizStudent> biz_students = new ArrayList<>();

  public void addStudent(Student student) {
    if(student instanceof ITStudent) {
      it_students.add((ITStudent) student);
    } else {
      biz_students.add((BizStudent) student); 
    }
  }

  public List<ITStudent> getItStudents() {
    return it_students;
  }

  public List<BizStudent> getBizStudents() {
    return biz_students;
  }

  public double getAverageScore(Student student) {
    if(student instanceof ITStudent) {
      return ((ITStudent)student).calculateAverage();
    } else {
      return ((BizStudent)student).calculateAverage();
    }
  }

  public boolean hasSameAge(Student s1, Student s2) {
    return s1.getAge() == s2.getAge();
  }
}
