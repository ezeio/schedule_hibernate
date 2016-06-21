import model.Employee;
import model.ServiceUser;
import model.WorkSchedule;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.HibernateUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
/**
 * Created by ositadinmaeze on 20/06/2016.
 */
public class WorkScheduleTest {

    @Before
    public void setUp(){

    }


    @After
    public void tearDown(){}


    @Test
    public void canCreateWorkSchedule(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalTime startTime = LocalTime.parse("07:00", timeFormatter);
        LocalTime endTime = LocalTime.parse("22:00", timeFormatter);

        LocalDate startDate = LocalDate.parse("21-06-2016",dateFormatter);
        LocalDate endDate = LocalDate.parse("21-06-2016", dateFormatter);

        Set<String> skillSet1 = new HashSet();
        skillSet1.add("Swimming");
        skillSet1.add("Driver");
        skillSet1.add("Medication trained");
        Employee employee1 = new Employee("Ositadinma","Henry", "Eze", "Male","Manager", skillSet1);
        ServiceUser serviceUser1 = new ServiceUser("Sadick", "Muyingo");

        WorkSchedule workSchedule1 = new WorkSchedule(startTime,endTime,startDate,endDate,"My first work schedule note", employee1, serviceUser1);

        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(employee1);
            session.save(serviceUser1);
            Long savedWorkScheduleId = (Long) session.save(workSchedule1);
            transaction.commit();

            Assert.assertEquals(savedWorkScheduleId, session.get(WorkSchedule.class, savedWorkScheduleId).getId());

        }
        catch (Exception exception){
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }


}
