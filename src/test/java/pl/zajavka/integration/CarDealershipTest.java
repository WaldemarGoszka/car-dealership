package pl.zajavka.integration;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarDealershipTest {

    @Test
    @Order(1)
    void purge() {
        log.info("### RUNING ORDER 1");

    }

    @Test
    @Order(2)
    void init() {
        log.info("### RUNING ORDER 2");

    }

    @Test
    @Order(3)
    void purchase() {
        log.info("### RUNING ORDER 3");

    }

    @Test
    @Order(4)
    void makeServiceRequest() {
        log.info("### RUNING ORDER 4");

    }

    @Test
    @Order(5)
    void processServiceRequest() {
        log.info("### RUNING ORDER 5");

    }

    @Test
    @Order(6)
    void printCarHistory() {
        log.info("### RUNING ORDER 6");

    }
}
