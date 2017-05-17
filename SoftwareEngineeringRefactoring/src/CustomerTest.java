import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Mario on 17.05.2017.
 */
@RunWith(Arquillian.class)
public class CustomerTest {

    Customer customer;

    @Test
    public void testStatement(){
        customer = new Customer("Mario");

        Movie movieOne = new Movie("One", 5);
        Movie movieTwo = new Movie("One", 3);
        Movie movieThree = new Movie("Three", 4);
        Movie movieFour = new Movie("Four", 2);

        Rental rentalOne = new Rental(movieOne, 3);
        Rental rentalTwo = new Rental(movieTwo, 3);
        Rental rentalThree = new Rental(movieThree, 3);

        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);
        customer.addRental(rentalThree);

        String expect ="Rental Record for fabi\n"+
                				"\tTitle		Days	Amount\n"+
                				"\ta		4	5.0\n"+
                				"\tb		5	15.0\n"+
                				"\tc		6	6.0\n"+
                				"Amount owed is 26.0\n"+
                				"You earned 4 frequent renter points";
        String statement = customer.statement();
        assertEquals(expect, statement);
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Customer.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
