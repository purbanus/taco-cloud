//tag::allButFindById[]
package tacos.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
// Die extra methodes waren ook in de JDBC-variant overbodig

// Paar voorbeelden van JPA query methoden:
List<TacoOrder> findByDeliveryZip( String deliveryZip );
List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween( String deliveryZip, Date startDate, Date endDate );

// Deze doen het allemaal niet
//@Query("Order o where o.deliveryCity='Seattle'")
//List<TacoOrder> readOrdersDeliveredInSeattle();
//@Query("Order where order.deliveryCity='Seattle'")
//List<TacoOrder> readOrdersDeliveredInSeattle();
//@Query("Order by order.deliveryCity='Seattle'")
//List<TacoOrder> readOrdersDeliveredInSeattle();

// Deze doen het wel!
@Query("select o from TacoOrder o where o.deliveryCity = 'Amsterdam'")
List<TacoOrder> readOrdersDeliveredInAmsterdam();
@Query("select o from TacoOrder o where o.deliveryCity = ?1")
List<TacoOrder> readOrdersDeliveredInACity( String aCityName );


}
