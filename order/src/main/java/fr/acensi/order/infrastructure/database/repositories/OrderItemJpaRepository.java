package fr.acensi.order.infrastructure.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.acensi.order.infrastructure.database.jpaEntities.OrderItemJpa;

@Repository
public interface OrderItemJpaRepository extends JpaRepository<OrderItemJpa, Long> {
}
