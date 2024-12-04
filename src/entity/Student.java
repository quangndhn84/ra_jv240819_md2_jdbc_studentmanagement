package entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private boolean status;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên: ");
        this.studentId = scanner.nextLine();
        System.out.println("Nhập vào tên sinh viên:");
        this.studentName = scanner.nextLine();
        System.out.println("Nhập vào tuổi sinh viên:");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giới tính:");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    public void dispayData() {
        System.out.printf("StudentID: %s - Student Name: %s - Age: %d - Status: %s\n",
                this.studentId, this.studentName, this.age, this.status ? "Male" : "Female");
    }
}
