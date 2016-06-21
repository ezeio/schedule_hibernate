import model.ServiceUser;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.HibernateUtil;
import java.util.ArrayList;

/**
 * Created by ositadinmaeze on 17/06/2016.
 */

public class ServiceUserTest {

    private ServiceUser serviceUser1;
    private ServiceUser serviceUser2;
    private ServiceUser serviceUser3;
    Long serviceUser1Id = null;
    Long serviceUser2Id = null;
    Long serviceUser3Id = null;

    @Before
    public void setUp(){
        serviceUser1 = new ServiceUser("Sadick", "Muyingo");
        serviceUser2 = new ServiceUser("Rachel", "Ugule");
        serviceUser3 = new ServiceUser("Serena", "Awda");

        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            serviceUser1Id = (Long) session.save(serviceUser1);
            serviceUser2Id = (Long) session.save(serviceUser2);
            serviceUser3Id = (Long) session.save(serviceUser3);

            transaction.commit();
        }
        catch (Exception exception){
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



    @After
    public void tearDown(){
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(serviceUser1);
            session.delete(serviceUser2);
            session.delete(serviceUser3);

            transaction.commit();
        }
        catch (Exception exception){
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
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
    public void canFindServiceUser(){
        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            ServiceUser returnedServiceUser1 = (ServiceUser) session.get(ServiceUser.class, serviceUser1Id);
            ServiceUser returnedServiceUser2 = (ServiceUser) session.get(ServiceUser.class, serviceUser2Id);
            ServiceUser returnedServiceUser3 = (ServiceUser) session.get(ServiceUser.class, serviceUser3Id);
            transaction.commit();

            Assert.assertEquals(serviceUser1Id, returnedServiceUser1.getId());
            Assert.assertEquals(serviceUser2Id, returnedServiceUser2.getId());
            Assert.assertEquals(serviceUser3Id, returnedServiceUser3.getId());

        }catch(Exception exception){
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally{
            if (session != null){
                session.close();
            }
        }
    }


    @Test
    public void canCreateServiceUser(){

        ServiceUser serviceUser = new ServiceUser("Becky", "Alexandra");

        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long savedServiceUserId = (Long) session.save(serviceUser);
            ServiceUser returnedServiceUser = (ServiceUser) session.get(ServiceUser.class, savedServiceUserId);

            transaction.commit();
            Assert.assertEquals(savedServiceUserId, returnedServiceUser.getId());
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

    @Test
    public void canEditServiceUser(){
        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            ServiceUser returnedServiceUser = (ServiceUser) session.get(ServiceUser.class,serviceUser1Id);
            String firstNameBeforeEdit = returnedServiceUser.getFirstName();
            String lastNameBeforeEdit = returnedServiceUser.getLastName();
            returnedServiceUser.setFirstName("Hannah");
            returnedServiceUser.setLastName("Notermans");
            transaction.commit();

            Assert.assertFalse(firstNameBeforeEdit.equals(returnedServiceUser.getFirstName()));
            Assert.assertFalse(lastNameBeforeEdit.equals(returnedServiceUser.getLastName()));
        }catch (Exception exception){
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exception.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Test
    public void canDeleteServiceUser(){

        Session session = null;
        Transaction transaction = null;

        ServiceUser serviceUser = new ServiceUser("Heather","Northermans");
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long returnedServiceUserId = (Long) session.save(serviceUser);
            session.delete(serviceUser);
            transaction.commit();

            Assert.assertEquals(null, session.get(ServiceUser.class, returnedServiceUserId));
        }
        catch (Exception exception){
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK){
                transaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            if (session != null){

            }
        }
    }


}
