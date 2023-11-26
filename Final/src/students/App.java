package students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        System.out.println("************************************************** START NOW **************************************************");
        init();
        System.out.println("========================================== Original Data ==========================================");
        testOriginalData();
        System.out.println("------------------------------------------------------------------");
        System.out.println("========================================== Sort BirthDay ==========================================");
        System.out.println("Increasing:");
        testSortYearOfBirthIncreasing();
        System.out.println("Decreasing:");
        testSortYearOfBirthDecreasing();
        System.out.println("------------------------------------------------------------------");
        System.out.println("========================================== Sort Average ==========================================");
        System.out.println("Increasing:");
        testSortAverageGradeIncreasing();
        System.out.println("Decreasing:");
        testSortAverageGradeDecreasing();
        System.out.println("------------------------------------------------------------------");
        System.out.println("========================================== Filter Math Grade ==========================================");
        System.out.println("Lowest Maths Grade:");
        testFilterStudentsLowestMathsGrade();
        System.out.println("Highest Maths Grade:");
        testFilterStudentsHighestMathsGrade();
        System.out.println("------------------------------------------------------------------");
        System.out.println("========================================== Filter Average Grade ==========================================");
        System.out.println("Lower Than Average Grade:");
        testFilterStudentsLowerThanAverageGrade();
        System.out.println("Highest Average Grade:");
        testFilterStudentsHighestAverageGrade();
        System.out.println("Lowest Average Grade:");
        testFilterStudentsLowestAverageGrade();

        System.out.println("************************************************** THE END **************************************************");



        /*
        TODO

        - Viết code để test cho tất cả các hàm bên dưới.
        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
        nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "src/data/students.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                Student student = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();

                StudentManager.getInstance().append(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.println(studentIds);
    }

    public static void testSortYearOfBirthIncreasing() {
        List<Student> students = StudentManager.getInstance().sortYearOfBirthIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.println(studentIdsString);
    }

    public static void testSortYearOfBirthDecreasing() {
        List<Student> students = StudentManager.getInstance().sortYearOfBirthDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.println(studentIdsString);
    }

    public static void testSortAverageGradeIncreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortAverageGradeIncreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.println(studentIdsString);
    }

    public static void testSortAverageGradeDecreasing() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().sortAverageGradeDecreasing();
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.println(studentIdsString);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        List<Student> students = StudentManager.getInstance().sortMathsGradeDecreasing();
        List<Student> nHighestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nHighestMathsGradeStudents.add(students.get(i));
        }
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(nHighestMathsGradeStudents);
        System.out.println(studentIdsString);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        List<Student> students = StudentManager.getInstance().sortMathsGradeIncreasing();
        List<Student> nLowestMathsGradeStudents = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            nLowestMathsGradeStudents.add(students.get(i));
        }

        String codeString = StudentManager.getInstance().idOfStudentsToString(nLowestMathsGradeStudents);
        System.out.println(codeString);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsHighestAverageGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.println(studentIdsString);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsLowestAverageGrade(5);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.println(studentIdsString);
    }

    public static void testFilterStudentsHigherThanAverageGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsHigherThanAverageGrade(6);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.println(studentIdsString);
    }

    public static void testFilterStudentsLowerThanAverageGrade() {
        /* TODO */
        List<Student> students = StudentManager.getInstance().filterStudentsLowerThanAverageGrade(6);
        String studentIdsString = StudentManager.getInstance().idOfStudentsToString(students);
        System.out.println(studentIdsString);
    }
}
