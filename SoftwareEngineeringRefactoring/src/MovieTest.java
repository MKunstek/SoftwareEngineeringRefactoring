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
public class MovieTest {

    @Test
    public void testTitle(){
        String title = "Movie";
        Movie movie = new Movie(title, 2);
        assertEquals(title, movie.getTitle());
    }

    @Test
 	public void testPriceCode() {
        int pt = 1;
        Movie m = new Movie("a",pt);
        assertEquals(pt, m.getPriceCode());
        pt = 0;
        m.setPriceCode(pt);
        assertEquals(pt, m.getPriceCode());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Movie.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
