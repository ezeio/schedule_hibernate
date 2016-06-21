import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.junit.*;
import org.junit.Test;
import util.HibernateUtil;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

/**
 * Created by ositadinmaeze on 17/06/2016.
 */

public class EmployeeTest {



    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Long employee1Id;
    private Long employee2Id;
    private Long employee3Id;


    @Before
    public void setUp(){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            //Employee one
            Set<String> netsaiSkillSet = new HashSet();
            netsaiSkillSet.add("Medication trained");
            netsaiSkillSet.add("Driver");
            employee1 = new Employee("Netsai","Mashiri","Female","Senior support worker",netsaiSkillSet);

            //Employee two
            Set<String> georgeSkillSet = new HashSet();
            georgeSkillSet.add("Medication trained");
            georgeSkillSet.add("Driver");
            employee2 = new Employee("George", "Thomas");

            //Employee three
            Set<String> karenSkillSet = new HashSet();
            karenSkillSet.add("Swimming");
            karenSkillSet.add("Driver");
            karenSkillSet.add("Medication trained");
            employee3 = new Employee("Karen","Becky","Jackman","Female","Support worker",karenSkillSet);

            employee1Id = (Long) session.save(employee1);
            employee2Id = (Long) session.save(employee2);
            employee3Id = (Long) session.save(employee3);
            transaction.commit();
        }
        catch(Exception exception){
            if(transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            session.close();
        }


    }
    @After
    public void tearDown(){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(employee1);
            session.delete(employee2);
            session.delete(employee3);
            transaction.commit();
        }
        catch(Exception exception){
            if(transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            session.close();
        }

    }

    @Test
    public void canFindEmployee(){
        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            //the start of a transaction to persist an employee object
            transaction = session.beginTransaction();

            Employee returnedEmployee1 = session.get(Employee.class, employee1Id);
            Employee returnedEmployee2 = session.get(Employee.class, employee2Id);
            Employee returnedEmployee3 = session.get(Employee.class, employee3Id);
            transaction.commit();
            //Assertions to test can find persisted Employees
            Assert.assertEquals(employee1Id, returnedEmployee1.getId());
            Assert.assertEquals(employee2Id, returnedEmployee2.getId());
            Assert.assertEquals(employee3Id, returnedEmployee3.getId());


        }
        catch (Exception exception){
            if(transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
    }
    @Test
    public void canCreatEmployee(){
        //Employee one
        Set<String> skillSet = new HashSet();
        skillSet.add("Medication trained");
        skillSet.add("Driver");
        skillSet.add("Swimmer");
        Employee employee = new Employee("Obum","Uche","Male","Support worker",skillSet);

        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Long savedEmployeeId = (Long) session.save(employee);
            Employee returnedEmployee = (Employee) session.get(Employee.class,savedEmployeeId);
            transaction.commit();

            Assert.assertEquals(savedEmployeeId, returnedEmployee.getId());
        }
        catch (Exception exceiption){
            if(transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exceiption.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void canDeleteEmployee(){
        Set <String> skillSet = new HashSet();
        skillSet.add("Swimming");
        skillSet.add("Driving");
        Employee employee1 = new Employee();
        Employee employee2 = new Employee("Rio","Peter", "Fedinand","Male","Manager",skillSet);

        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            Long returnedEmployee1id = (Long) session.save(employee1);
            Long returnedEmployee2id = (Long) session.save(employee2);
            session.delete(employee1);
            session.delete(employee2);
            transaction.commit();

            Assert.assertEquals(null, session.get(Employee.class, returnedEmployee1id));
            Assert.assertEquals(null, session.get(Employee.class, returnedEmployee2id));
        }
        catch(Exception exception) {
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
        }
            exception.printStackTrace();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }
    @Test
    public void canEditEmployee(){
        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String firstNameBeforeEdit = session.get(Employee.class, employee1Id).getFirstName();
            String lastNameBeforeEdit = session.get(Employee.class, employee1Id).getLastName();


            session.get(Employee.class, employee1Id).setFirstName("Philip");
            session.get(Employee.class, employee1Id).setLastName("Brown");

            String firstNameAfterEdit = session.get(Employee.class, employee1Id).getFirstName();
            String lastNameAfterEdit = session.get(Employee.class, employee1Id).getLastName();
            transaction.commit();

            Assert.assertNotEquals(true, firstNameBeforeEdit.equals(firstNameAfterEdit));
            Assert.assertNotEquals(true, lastNameBeforeEdit.equals(lastNameAfterEdit));
        }
        catch (Exception exception){
            if(transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }
}
