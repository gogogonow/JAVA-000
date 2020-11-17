import com.tw.car.BMWCar;
import com.tw.car.FerrariCar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 61404
 */
@ContextConfiguration({"classpath*:com/tw/config/config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class Main {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/tw/config/config.xml");
    FerrariCar ferrariCar = (FerrariCar) applicationContext.getBean("ferrariCar");
    BMWCar bmwCar = (BMWCar) applicationContext.getBean("bmwCar");

    @Test
    public void main() {
        ferrariCar.drive();
        bmwCar.drive();
    }
}
