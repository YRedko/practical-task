package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.domain.Employee;
import project.domain.Opportunity;
import project.domain.enums.OpportunityType;

import java.util.Date;
import java.util.List;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    @Query("select o from Opportunity  o where o.sales = :employee")
    List<Opportunity> findByEmployee(@Param("employee") Employee employee);

//    @Query("select o from Opportunity o where o.type = :type")
    List<Opportunity> findByType(OpportunityType type);

    @Query("select o from Opportunity o where (" +
            "o.start between :firstBorder and :secondBorder or o.end between :firstBorder and :secondBorder) " +
            "or (o.start <= :firstBorder and o.end >= :secondBorder) ")
    List<Opportunity> findForPeriodOfTime(@Param("firstBorder") Date firstBorder, @Param("secondBorder") Date secondBorder);
}
