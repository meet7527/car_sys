package edu.nf.carsys;

import edu.nf.carsys.entity.CarUser;
import edu.nf.carsys.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class CarSysApplicationTests {

    @Autowired
    private CarService carService;

    @Autowired
    private DataSource dataSource;

    @Test
    void test() throws SQLException {

        for (CarUser carUser : carService.getCarUserLi(1, 10).getList()) {
            System.out.println(carUser.getUserName());
        }
    }

}
