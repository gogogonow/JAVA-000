import com.tw.car.BMWCar;
import com.tw.car.FerrariCar;
import com.tw.config.CarConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 61404
 */
@ContextConfiguration(classes = CarConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Main {

    @Autowired
    private FerrariCar ferrariCar;

    @Autowired
    private BMWCar bmwCar;

    @Test
    public void main() {
        ferrariCar.drive();
        bmwCar.drive();
    }
}
