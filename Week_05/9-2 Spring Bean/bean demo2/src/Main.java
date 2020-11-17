import com.tw.car.BMWCar;
import com.tw.car.FerrariCar;
import com.tw.config.CarConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 61404
 */
@ContextConfiguration(classes = CarConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Main {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CarConfig.class);
    FerrariCar ferrariCar = applicationContext.getBean(FerrariCar.class);
    BMWCar bmwCar = applicationContext.getBean(BMWCar.class);

    @Test
    public void main() {
        ferrariCar.drive();
        bmwCar.drive();
    }
}
