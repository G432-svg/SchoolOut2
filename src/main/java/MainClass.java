import entities.*;
import entities.Module;
import repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class MainClass {
    public static void main(String[] args) {

        try {

//           ExamDAO examDAO =new ExamDAO();
//           Exam exam = new Exam(1,"FinalExam");
//           examDAO.createOne(examDAO.getOne("FinalExam"));

//          PersonDAO personDAO = new PersonDAO();
//          Person person = new Person("Hagi", "Gigi", Gender.MALE);
//          personDAO.updateOne(person);

//           personDAO.updateOne(new Person("Vincent","De Wolf",Gender.MALE));
//           personDAO.updateOne(personDAO.getOne(2));
//           personDAO.updateOne(new Person("Bob","Van Den Boss",Gender.MALE));
//           personDAO.updateOne(personDAO.getOne(3));
//           personDAO.updateOne(new Person("Bernadette","Van Gelluwe",Gender.FEMALE));
//           personDAO.updateOne(personDAO.getOne(4));
//           personDAO.updateOne(new Person("Bernard","Connery",Gender.OTHER));
//           personDAO.updateOne(personDAO.getOne(5));

//             Person person = personDAO.getOne(4);
//             personDAO.deleteOne(person);

//           List<Person> persons = new ArrayList<>();
//          persons.add("person1");
//          persons.add(person2);
//          persons.add(person3);
//          persons.add(person4);
//          for (Person p: persons){
//              System.out.println(p);
//          }



             UserDAO userDAO = new UserDAO();
             User user = new User("mukluk", "lollipop", true);
             userDAO.updateOne(user);
            System.out.println(user);
//             User user = userDAO.getOne("mukluk");
//             userDAO.deleteOne(user);



//             User user2 = new User("popi","monivca",true);
//             userDAO.updateOne(user2);
//           User user3 = new User("pliu","gogo",true);
//           userDAO.updateOne(user3);
//           User user4 = new User("dute","mimo",true);
//           userDAO.updateOne(user4);
//           User user5 = new User("dac","burebista",true);
//           userDAO.updateOne(user5);

//           CourseDAO courseDAO = new CourseDAO();
//           Course course = new Course("Java");
////         System.out.println(person);
//           courseDAO.createOne(new Course("JavaEE"));

//          ModuleDAO moduleDAO = new ModuleDAO();
//          Module module5 = new Module(4,"module4");
//          moduleDAO.updateOne(module5);

//          Module module4 = moduleDAO.getOne("module3");
//          moduleDAO.deleteOne(module4);

//
//          Module module1 = new Module(5);
//          Module module2 = new Module(6);

//          List<Module> modules = new ArrayList<>();
//          modules.add(module1);
//          modules.add(module2);
//          modules.add(module3);
//          modules.add(module4);
//          for (Module m: modules){
//              System.out.println(m);
//          }

//           ExamDAO examDAO = new ExamDAO();
//           Exam exam = new Exam(2,"Examen2");
//           Exam exam = new Exam(125,"OOP");
//           Exam exam = new Exam(143,"DataBase");
//           examDAO.updateOne(exam);


//           AttributeEncryptor attributeEncryptor = new AttributeEncryptor();
//           attributeEncryptor.convertToEntityAttribute("passwordHash");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            EMFConnection.getOtiliaEMF().close();
        }

    }
}