package pl.zajavka.integration;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarDealershipTest {

    @Test
    @Order(1)
    void purge() {

    }

    @Test
    @Order(2)
    void init() {

    }

    @Test
    @Order(3)
    void purchase() {

    }

    @Test
    @Order(3)
    void makeServiceRequest() {

    }

    @Test
    @Order(4)
    void processServiceRequest() {

    }

    @Test
    @Order(5)
    void printCarHistory() {

    }
}
