package services;


import entities.Gender;
import entities.Person;
import entities.User;
import repository.EMFConnection;
import repository.PersonDAO;
import repository.UserDAO;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UserService {

    private UserDAO userDAO ;
    private PersonService personService;
    private Scanner scanner;


    public UserService() {
        userDAO = new UserDAO();
        scanner = new Scanner(System.in);
        personService = new PersonService();
    }

    //HARD
    //1.Zorg ervoor dat een persoon ook aangemaakt wordt
    //2.Maak een controle methode die vraagt om een gebruiker een passwoord twee keer in te geven
    //3. Het wachtwoord wordt hier geincrypteerd
    public void createUser(){

        System.out.println("Create your user");
        System.out.println("Give your firstName");
        Person person = new Person();
        person.setFirstName(scanner.next());
        System.out.println("Give your lastName");
        person.setFamilyName(scanner.next());
        System.out.println("Choose your Gender, \n0. Other \n 1. Female \n 2.Male ");
        scanner.nextLine();
        int choice = scanner.nextInt();
        switch (choice){
            case 1: person.setGender(Gender.FEMALE);break;
            case 2: person.setGender(Gender.MALE);break;
            default:person.setGender(Gender.OTHER);
        }

        System.out.println("What do you want your login to be?");
        User user = new User();
        user.setLogin(scanner.next());
        user.setPasswordHash(checkPassword());
        user.setActive(true);
        user.setPerson(person);
        System.out.println(user);
        userDAO.createUser(user);


    }

    //EASY
    //Als er geen User terug gegeven wordt, stuur als bericht "User does not exist"
    public User getOneUserByName(){
        System.out.println("Enter the username in");
        String username = scanner.next();
        User user = userDAO.getUserById(username);
        if(user!= null)
            System.out.println(user);
        else System.out.println("User does not exist");

        return user;
    }

    //EASY
    //print een lijst uit van alle users.
    public void getAllUsers() throws SQLException {
        List<User> users = userDAO.getAllUsers();
        for (User user:users)
            System.out.println(users);

    }

    //EASY
    //Een username mag niet aangepast worden
    //Bonus HARD
    //De Person hoef je niet te updaten (als je dat wilt, doe je dat best via een aparte personservice,
    // via een aprte updatePersonMethode)
    public void updateUser(){
        System.out.println("Which user do you want to change?");
        User user = userDAO.getUserById(scanner.next());
        System.out.println(user.getPerson());

        System.out.println("change password? Y/N");
        String answer = scanner.next();
        if (answer.equals("Y"))
            user.setPasswordHash(checkPassword());

        System.out.println("do you want to change activity status of the account? Y/N");
        answer = scanner.next();
        if (answer.equals("Y"))
            user.setActive(!user.isActive());

        System.out.println("do you want to change the person? Y/N");
        answer = scanner.next();
        if (answer.equals("Y")) {
            Person person = user.getPerson();
            personService.updatePerson(person);

        }
//                if (answer.equals("Y")) {
//            Person person = updatePerson(user.getPerson());
//            user.setPerson(person);
//        }
        userDAO.updateUser(user);



    }

    //MEDIUM
    //Vraag de User een passwoord in te geven voor dat hij zijn account kan verwijderen.
    //De Person moet ook mee gedeleted worden
    public void deleteUser() throws SQLException {
        System.out.println("Which user do you want to delete");
        String login = scanner.next();
        User user = userDAO.getUserById(login);
        String passwordHash = user.getPasswordHash();
        System.out.println("insert your password");
        String passwordYouGaveIn = scanner.next();

        //compare passwordHash with passwordYouGaveIn .If they are equal ,delete the user.
        //else,nothing

        if (passwordHash.equals(passwordYouGaveIn)) {
        userDAO.deleteUser(user);
         }else{
            System.out.println("User was not deleted");
        }
        userDAO.deleteUser(user);


    }

        //----
        //extra private methodes hieronder



    private String checkPassword(){
        boolean samePassword = false;
        String password = null;

        while (samePassword == false) {
            System.out.println("Type in your password");
            password = scanner.next();
            System.out.println("Type in your password again");
            String password2 = scanner.next();
            if (password.equals(password2)) {
                samePassword = true;

            }
        }

        return password;
    }
    private Person updatePerson(Person person){
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
        return person;
    }


}

