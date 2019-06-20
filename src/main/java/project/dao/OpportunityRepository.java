package project.dao;

import project.domain.Employee;
import project.domain.Opportunity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OpportunityRepository {

    Opportunity save(Opportunity opportunity);

    List<Opportunity> findAll();

    List<Opportunity> findByEmployee(Employee employee);

    List<Opportunity> findByType();

    List<Opportunity> findForPeriodOfTime(LocalDate firstBorder, LocalDate secondBorder);

    Optional<Opportunity> findById(Long id);

    void delete(Long id);
}
