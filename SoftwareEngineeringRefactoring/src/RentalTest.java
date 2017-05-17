import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Mario on 17.05.2017.
 */
@RunWith(Arquillian.class)
public class RentalTest {
    Movie movieOne, movieTwo;
 	int days = 5;
 	Rental rental1, rental2, rental3;

    @Before
 	public void setUp(){
        movieOne = new Movie("testOne",1);
        movieTwo = new Movie("testTwo",2);

        rental1 = new Rental(movieOne, days);
        rental2 = new Rental(movieTwo, days);
        rental3 = new Rental(movieOne, days);
	}

    @Test
 	public void testGetDaysRented() {
        assertEquals(days, rental1.getDaysRented());
    }

    @Test
 	public void testGetMovie() {
    	assertEquals(movieOne, rental1.getMovie());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Rental.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
