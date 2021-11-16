package services;
import entities.Grade;
import entities.Person;
import entities.User;
import repository.GradeDAO;
import repository.UserDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class GradeService {
    private GradeDAO gradeDAO;
    private Scanner scanner;
    private UserDAO userDAO ;

    public GradeService() {
        gradeDAO = new GradeDAO();
        userDAO = new UserDAO();

        Scanner scanner = new Scanner(System.in);
    }

    //SUPER HARD
    //De datum staat automatisch op vandaag
    //de grade mag niet minder dan 0 zijn, en mag niet meer zijn dan de punten van het examen
    //Je gaat een Exam moeten oproepen van de bestaande lijst van examens, Exam mag dus niet op null staan
    //Je gaat een Person moeten terugvinden met User
    public void createGrade(User user){
        System.out.println("Create your grade");
        // If (Percentage gradeValues > 90, Grade is A+);
        //If 70 <= Percentage gradeValues <= 89, Grade is A;
        //If 60 <= Percentage gradeValues <= 69, Grade is B;
        //If 50 <= Percentage gradeValues <= 59, Grade is C;
        //If Percentage gradeValues <= 40, Grade is D;
        Person person = new Person();
        person = user.getPerson();

        int count, i;
//        BigDecimal gradeValues = 0;
        BigDecimal percentage;
        BigDecimal average;
        Scanner scanner ;
        scanner = new Scanner(System.in);



//        System.out.println("Enter Number of subExams");
//        count = scanner.nextInt();
//
//        System.out.println("Enter Value of " + count + " exam");
//        for (i = 0; i < count; i++) {
//            totalGradeValues += scanner.nextBigDecimal();
//        }
//        System.out.println("Total GradeValues : " + totalGradeValues);
//        // Each exam is of 100 Values
//        percentage = (totalGradeValues / (count * 100)) * 100;
//
//        /* Printing grade of a person using switch case statement */
//        switch ((BigDecimal) percentage / 10) {
//            case 9:
//                System.out.println("Grade : A+");
//                break;
//            case 8:
//            case 7:
//                System.out.println("Grade : A");
//                break;
//            case 6:
//                System.out.println("Grade : B");
//                break;
//            case 5:
//                System.out.println("Grade : C");
//                break;
//            default:
//                System.out.println("Grade : D");
//                break;
//        }
    }


    //EASY
    public Grade getOneGradeById(){
        System.out.println("Enter the grade in");
       long gradeId = scanner.nextLong();
        Grade grade = gradeDAO.getOne(gradeId);
        System.out.println(grade);
        return grade;
    }

    //MEDIUM
    //Controleer eerst of de user niet 'null' is
    //Gebruik een user.getPerson methode, en maak een extra methode in je DAO/repository om resultaten op te vragen met person
    public void getAllGradeByPerson(User user){
        if(user != null) {
            Person person = new Person();

            person = user.getPerson();
           List<Grade> gradeList = gradeDAO.getAll();
           for (Grade grade : gradeList){
            if(grade.getPerson().equals(person)) {
                System.out.println("Grade : " + grade.getGradeValue());
            }

           }
        }else {
            System.out.println("user is not filled in");
        }
    }

    //HARD
    //Controleer eerst of de user niet 'null' is
    //vraag alle grades op van een Person en kies de Grade die je wilt aanpassen
    //Enkel de gradeValue en de comment mogen aangepast worden
    //de grade mag niet minder dan 0 zijn, en mag niet meer zijn dan de punten van het examen
    public void updateGrade(User user){
//        if(user != null) {
//            getAllGradeByPerson(user);
//            System.out.println("Chose the ID of the grade you want to update");
//            Grade grade = grade.getGradeById(scanner.nextInt());
//
//            System.out.println("What is the grade now?");
//            grade.setResults(scanner.nextDouble());
//
//            grade.updateGrades(grade);
//        }else{
//            System.out.println("user is not filled in");
//        }

    }

    //EASY
    //Controleer eerst of de user niet 'null' is
    //vraag alle grades op van een Person en kies de Grade die je wilt aanpassen
    public void deleteGrade(User user){
      if(user != null){
          getAllGradeByPerson(user);
            System.out.println("which grade do you want to remove (choose 1 id");


      }else{
            System.out.println("user is not filled in");
      }
    }

    //----
    //extra private methodes hieronder
}

