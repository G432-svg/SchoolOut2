package services;

import entities.Gender;
import entities.Person;
import repository.PersonDAO;

import java.util.Scanner;

public class PersonService {

    private PersonDAO personDAO;
    private Scanner scanner;

    public PersonService() {
        personDAO = new PersonDAO();
        scanner = new Scanner(System.in);
    }

    public void updatePerson(Person person){
        System.out.println("change first name? Y/N");
        String answer = scanner.next();
        if(answer.equals("Y"));
        person.setFirstName(scanner.next());

        System.out.println("change family name? Y/N");
        answer = scanner.next();
        if(answer.equals("Y"));
        person.setFamilyName(scanner.next());
        System.out.println("change gender? Y/N");
        answer = scanner.next();
        if(answer.equals("Y")) {

            System.out.println("Choose your Gender, \n0. Other \n 1. Female \n 2.Male ");
            scanner.nextLine();
            int choice = scanner.nextInt();
            switch (choice) {
                case 2:
                    person.setGender(Gender.FEMALE);
                    break;
                case 3:
                    person.setGender(Gender.MALE);
                    break;
                default:
                    person.setGender(Gender.OTHER);
            }
        }
        personDAO.updateOne(person);

    }

}
