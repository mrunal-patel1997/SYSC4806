import Spring.AddressBook;
import Spring.BuddyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo dummyBuudy;
    private String name = "Raven";
    private String address = "123 Bronson Ave";
    private String phonenumber = "613 - 420 - 6969";

    @Before
    public void setUp() throws Exception {
        this.dummyBuudy = new BuddyInfo(name, address, phonenumber);
    }

    @After
    public void tearDown() throws Exception {
        this.dummyBuudy = null;
        assertNull(dummyBuudy);
    }

    @Test
    public void getAddress() {
        System.out.println("Initiating: getAddress Test");
        assertEquals("123 Bronson Ave", dummyBuudy.getAddress());
        System.out.println("Test: Success");
    }

    @Test
    public void setAddress() {
        System.out.println("Initiating: setAddress Test");
        dummyBuudy.setAddress("123 Colonel By");
        assertEquals("123 Colonel By", dummyBuudy.getAddress());
        System.out.println("Test: Success");
    }

    @Test
    public void getName(){
        System.out.println("Initiating: getName Test");
        assertEquals("Raven", dummyBuudy.getName());
        System.out.println("Test: Success");
    }

    @Test
    public void setName(){
        System.out.println("Initiating: setName Test");
        dummyBuudy.setName("Carleton U");
        assertEquals("Carleton U", dummyBuudy.getName());
        System.out.println("Test: Success");
    }

    @Test
    public void getPhonenumber() {
        System.out.println("Initiating: getPhonenumber Test");
        assertEquals("613 - 420 - 6969", dummyBuudy.getPhonenumber());
        System.out.println("Test: Success");
    }

    @Test
    public void setNum() {
        System.out.println("Initiating: setNum Test");
        dummyBuudy.setNum("613 - 696 - 4200");
        assertEquals("613 - 696 - 4200", dummyBuudy.getPhonenumber());
        System.out.println("Test: Success");
    }

    @Test
    public void phonenumber() {
        System.out.println("Initiating: phonenumber Test");
        dummyBuudy.setNum("647 - 795 - 8321");
        assertEquals("647 - 795 - 8321", dummyBuudy.getPhonenumber());
        System.out.println("Test: Success");
    }

    @Test
    public void performJPA(){

        //create buddy objects
        BuddyInfo bud, bud1, bud2, bud3;

        bud = new BuddyInfo ("test", "address", "num");
        bud1 = new BuddyInfo ("test1", "add1", "num1");
        bud2 = new BuddyInfo ("test2", "add2", "num2");
        bud3 = new BuddyInfo ("test3", "add3", "num3");

        bud.setId(1);
        bud1.setId(2);
        bud2.setId(3);
        bud3.setId(4);

        AddressBook address = new AddressBook();
        address.setId(1);
        address.addBuddy(bud);
        address.addBuddy(bud1);
        address.addBuddy(bud2);
        address.addBuddy(bud3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(address);

        tx.commit();

        System.out.println("Initiating: JPA Test");
        Query q = em.createQuery("SELECT p FROM BuddyInfo p");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (BuddyInfo p : results) {

            System.out.println(p.getName() + " (id=" + p.getId() + ")");
        }


    }
}