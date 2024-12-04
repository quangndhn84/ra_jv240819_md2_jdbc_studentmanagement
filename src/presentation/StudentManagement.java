package presentation;

import business.StudentBusiness;
import entity.Student;

import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******************MENU*******************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tính số lượng sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListStudent();
                    break;
                case 2:
                    createStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    getCountStudentByName(scanner);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }

    public static void displayListStudent() {
        List<Student> listStudents = StudentBusiness.findAllStudent();
        listStudents.forEach(Student::dispayData);
    }

    public static void createStudent(Scanner scanner) {
        Student student = new Student();
        student.inputData(scanner);
        boolean result = StudentBusiness.createStudent(student);
        if (result) {
            System.out.println("Thêm mới thành công");
        } else {
            System.err.println("Thêm mới thất bại");
        }
    }

    public static Student findById(String studentId) {
        return StudentBusiness.findById(studentId);
    }

    public static void updateStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần cập nhật:");
        String studentId = scanner.nextLine();
        Student studentUpdate = findById(studentId);
        if (studentUpdate != null) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sinh viên");
                System.out.println("2. Cập nhật tuổi sinh viên");
                System.out.println("3. Cập nhật trạng thái sinh viên");
                System.out.println("4. Thoát");
                System.out.print("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên sinh viên cập nhật:");
                        studentUpdate.setStudentName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào tuổi sinh viên cần cập nhật:");
                        studentUpdate.setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào trạng thái sinh viên cập nhật:");
                        studentUpdate.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-4");
                }
            } while (isExit);
            //Gọi business để cập nhật
            boolean result = StudentBusiness.updateStudent(studentUpdate);
            if (result) {
                System.out.println("Cập nhật thành công");
            } else {
                System.err.println("Cập nhật thất bại");
            }
        } else {
            System.err.println("Mã sinh viên không tồn tại");
        }

    }

    public static void deleteStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần xóa:");
        String studentId = scanner.nextLine();
        Student studentDelete = findById(studentId);
        if (studentDelete != null) {
            boolean result = StudentBusiness.deleteStudent(studentId);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.err.println("Xóa thất bại");
            }
        } else {
            System.err.println("Mã sinh viên không tồn tại");
        }
    }

    public static void getCountStudentByName(Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên cần thống kê số luợng:");
        String studentName = scanner.nextLine();
        int cntStudent = StudentBusiness.getCountStudentByName(studentName);
        if (cntStudent > 0) {
            System.out.printf("Có %d sinh viên có chứa tên %s\n", cntStudent, studentName);
        } else {
            System.out.println("Không tồn tại sinh viên chứa tên như vậy");
        }
    }
}
