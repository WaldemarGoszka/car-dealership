package pl.zajavka.infrastructure.database.repository;

import org.hibernate.Session;
import pl.zajavka.business.dao.management.CarDealershipManagementDAO;
import pl.zajavka.infrastructure.configuration.HibernateUtil;

import java.util.List;
import java.util.Objects;

public class CarDealershipManagementRepository implements CarDealershipManagementDAO {
    @Override
    public void purge() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            session.createMutationQuery("DELETE FROM CarServiceRequestEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM ServicePartEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM ServiceMechanicEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM InvoiceEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM MechanicEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM PartEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM ServiceEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM CarToServiceEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM CarToBuyEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM CustomerEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM AddressEntity").executeUpdate();
            session.createMutationQuery("DELETE FROM SalesmanEntity").executeUpdate();

            session.getTransaction().commit();
        }
    }

    @Override
    public void saveAll(List<?> entities) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            for (var entity : entities) {
                session.persist(entity);
            }

            session.getTransaction().commit();
        }
    }
}
