package pl.zajavka.integration;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import pl.zajavka.infrastructure.configuration.HibernateUtil;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarDealershipTest {
    @AfterAll
    static void afterAll() {
        HibernateUtil.closeSessionFactory();
    }

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
package pl.zajavka.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "salesmanId")
@ToString(of = { "salesmanId", "name", "surname", "pesel" })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "salesman")

public class SalesmanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salesman_id")
    private Integer salesmanId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "pesel")
    private String pesel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "salesman")
    private Set<InvoiceEntity> invoices;
}
@OneToMany(fetch = FetchType.EAGER,mappedBy = "customer")
private Set<InvoiceEntity> invoices;