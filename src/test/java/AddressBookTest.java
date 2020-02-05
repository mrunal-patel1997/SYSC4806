import Spring.AddressBook;
import Spring.BuddyInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook dummyaddress;
    private BuddyInfo dummyBud, dummyBud1, dummyBud2;;


    @Before
    public void setUp() throws  Exception{
        this.dummyaddress = new AddressBook();
        this.dummyBud = new BuddyInfo("test", "address", "num");
        this.dummyBud1 = new BuddyInfo ("test1", "add1", "num1");
        this.dummyBud2 = new BuddyInfo ("test2", "add2", "num2");
    }

    @After
    public void tearDown() throws  Exception{
        this.dummyaddress = null;
        assertNull(dummyaddress);
    }


    @Test
    public void addBuddy() {
        System.out.println("Initiating: addBuddy Test");
        dummyaddress.addBuddy(dummyBud);
        assertNotNull(dummyaddress);
        System.out.println("addBuddy Test: Success");
    }

    @Test
    public void removeBuddy() {
        System.out.println("Initiating: removeBuddy Test");
        dummyaddress.addBuddy(dummyBud);
        dummyaddress.removeBuddy(dummyBud);
        assertEquals(0, dummyaddress.size());
        System.out.println("removeBuddy Test: Success");
    }

    @Test
    public void removeBuddy1() {
        System.out.println("Initiating: removeBuddy1 Test");

        dummyaddress.addBuddy(dummyBud);
        dummyaddress.addBuddy(dummyBud1);
        dummyaddress.addBuddy(dummyBud2);

        dummyaddress.removeBuddy(2);
        assertEquals(2, dummyaddress.size());
        System.out.println("removeBuddy1 Test: Success part 1");

        dummyaddress.removeBuddy(1);
        assertEquals(1, dummyaddress.size());

        System.out.println("removeBuddy1 Test: Success part 2");
    }


    @Test
    public void get() {
        System.out.println("Initiating: get Test");
        dummyaddress.addBuddy(dummyBud);
        dummyaddress.addBuddy(dummyBud1);
        dummyaddress.addBuddy(dummyBud2);
        //There is an error here because the test doesn't account for the id. Need to fix
        String ret = dummyaddress.get(1).toString();
        assertEquals("id,test1,add1,num1", ret);
        System.out.println("get Test: Success");
    }

    @Test
    public void size() {
        System.out.println("Initiating: size Test");
        dummyaddress.addBuddy(dummyBud);
        dummyaddress.addBuddy(dummyBud1);
        dummyaddress.addBuddy(dummyBud2);

        assertEquals(3, dummyaddress.size());
        System.out.println("size Test: Success");
    }

}