package services;

import entities.Exam;
import entities.Gender;
import repository.ExamDAO;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;

public class ExamService {

    private ExamDAO examDAO = new ExamDAO();
    private Scanner scanner = new Scanner(System.in);


    public ExamService() {
        examDAO = new ExamDAO();
        scanner = new Scanner(System.in);

    }

    public void updateExam(Exam exam) {
        examDAO = new ExamDAO();
        System.out.println("change exam name? Y/N");
        String answer = scanner.next();
        if (answer.equals("Y")) ;
        exam.setName(scanner.next());

        System.out.println("change Description? Y/N");
        answer = scanner.next();
        if (answer.equals("Y")) ;
        exam.setDescription(scanner.next());
        System.out.println("change date? Y/N");
        if (answer.equals("Y")) ;
        exam.setDate(exam.getDate());
        System.out.println("change Weight? Y/N");
        if (answer.equals("Y")) ;
        exam.setWeight(exam.getWeight());
        System.out.println("change total? Y/N");
        if (answer.equals("Y")) ;
        exam.setTotal(exam.getTotal());
        System.out.println("change module? Y/N");
        if (answer.equals("Y")) ;
        exam.setModule(exam.getModule());
        System.out.println("change examGroup? Y/N");
        if (answer.equals("Y")) ;
        exam.setExamGroup(exam.getExamGroup());
        System.out.println("change List subExams? Y/N");
        answer = scanner.next();
        if (answer.equals("Y")) {

            System.out.println("Choose your ExamGroup, \n1. Java \n 2. JavaIot \n 3.JavaEE ");
            scanner.nextLine();
            int choice = scanner.nextInt();
            switch (choice) {
                case 2:
                    exam.setExamGroup(exam.getExamGroup());
                    break;
                case 3:
//                    exam.setExamGroup(exam.getName(JavaIot);
//                    break;
//                default:
//                    exam.setExamGroup(List<Exams> subExams);
//            }
            }
            examDAO.updateExam(exam);


        }
//    public void outputExam(Long id){
//        List<Exam> subExams = examDAO.getExamById();
//
//
//    }

    }
}


