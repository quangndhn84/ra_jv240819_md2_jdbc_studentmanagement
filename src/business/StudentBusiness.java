package business;

import entity.Student;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class StudentBusiness {
    // 1. FindAll
    public static List<Student> findAllStudent() {
        //1. Khởi tạo đối tượng Connection, CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2. Khởi tạo danh sách sinh viên trả về
        List<Student> listStudents = null;
        try {
            //3. Khởi tạo giá trị cho đối tượng conn, callSt
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_student()}");
            //4. Set giá trị cho các tham số vào
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Thực hiện gọi procedure
            /*
             *   - procedure chỉ có câu lệch select: executeQuery()
             *   - procedure chỉ có các tham số vào: executeUpdate()
             *   - procedure có tham số trả ra: execute()
             * */
            ResultSet rs = callSt.executeQuery();
            //7. Xử lý kết quả
            listStudents = new ArrayList<Student>();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("student_age"));
                student.setStatus(rs.getBoolean("student_status"));
                listStudents.add(student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //Đóng kết nối
            ConnectionDB.closeConnecction(conn, callSt);
        }
        return listStudents;
    }

    // 2. FindById
    public static Student findById(String studentId) {
        //1. Khởi tạo đối tượng Connection, CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2. Khởi tạo sinh viên trả về

        try {
            //3. Khởi tạo giá trị cho đối tượng conn, callSt
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_by_id(?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setString(1, studentId);
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Thực hiện gọi procedure
            /*
             *   - procedure chỉ có câu lệch select: executeQuery()
             *   - procedure chỉ có các tham số vào: executeUpdate()
             *   - procedure có tham số trả ra: execute()
             * */
            ResultSet rs = callSt.executeQuery();
            //7. Xử lý kết quả
            if (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("student_age"));
                student.setStatus(rs.getBoolean("student_status"));
                return student;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //Đóng kết nối
            ConnectionDB.closeConnecction(conn, callSt);
        }
        return null;
    }

    // 3. Create Student
    public static boolean createStudent(Student student) {
        //1. Khởi tạo đối tượng Connection, CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2. Khởi tạo kết quả trả về
        boolean result = false;
        try {
            //3. Khởi tạo giá trị cho đối tượng conn, callSt
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_student(?,?,?,?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setString(1, student.getStudentId());
            callSt.setString(2, student.getStudentName());
            callSt.setInt(3, student.getAge());
            callSt.setBoolean(4, student.isStatus());
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Thực hiện gọi procedure
            /*
             *   - procedure chỉ có câu lệch select: executeQuery()
             *   - procedure chỉ có các tham số vào: executeUpdate()
             *   - procedure có tham số trả ra: execute()
             * */
            callSt.executeUpdate();
            //7. Xử lý kết quả
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //Đóng kết nối
            ConnectionDB.closeConnecction(conn, callSt);
        }
        return false;
    }

    // 4. Update Student
    public static boolean updateStudent(Student student) {
        //1. Khởi tạo đối tượng Connection, CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2. Khởi tạo kết quả trả về
        boolean result = false;
        try {
            //3. Khởi tạo giá trị cho đối tượng conn, callSt
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?,?,?,?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setString(1, student.getStudentId());
            callSt.setString(2, student.getStudentName());
            callSt.setInt(3, student.getAge());
            callSt.setBoolean(4, student.isStatus());
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Thực hiện gọi procedure
            /*
             *   - procedure chỉ có câu lệch select: executeQuery()
             *   - procedure chỉ có các tham số vào: executeUpdate()
             *   - procedure có tham số trả ra: execute()
             * */
            callSt.executeUpdate();
            //7. Xử lý kết quả
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //Đóng kết nối
            ConnectionDB.closeConnecction(conn, callSt);
        }
        return false;
    }

    // 5. Delete Student
    public static boolean deleteStudent(String studentId) {
        //1. Khởi tạo đối tượng Connection, CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2. Khởi tạo kết quả trả về
        boolean result = false;
        try {
            //3. Khởi tạo giá trị cho đối tượng conn, callSt
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_student(?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setString(1, studentId);
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Thực hiện gọi procedure
            /*
             *   - procedure chỉ có câu lệch select: executeQuery()
             *   - procedure chỉ có các tham số vào: executeUpdate()
             *   - procedure có tham số trả ra: execute()
             * */
            callSt.executeUpdate();
            //7. Xử lý kết quả
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //Đóng kết nối
            ConnectionDB.closeConnecction(conn, callSt);
        }
        return false;
    }

    // 6. Get count student by name
    public static int getCountStudentByName(String studentName) {
        //1. Khởi tạo đối tượng Connection, CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2. Khởi tạo kết quả trả về
        int cntStudent = 0;
        try {
            //3. Khởi tạo giá trị cho đối tượng conn, callSt
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_cnt_student_by_name(?,?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setString(1, studentName);
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            callSt.registerOutParameter(2, Types.INTEGER);
            //6. Thực hiện gọi procedure
            /*
             *   - procedure chỉ có câu lệch select: executeQuery()
             *   - procedure chỉ có các tham số vào: executeUpdate()
             *   - procedure có tham số trả ra: execute()
             * */
            callSt.execute();
            //7. Xử lý kết quả
            cntStudent = callSt.getInt(2);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //Đóng kết nối
            ConnectionDB.closeConnecction(conn, callSt);
        }
        return cntStudent;
    }
}
