package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.EmployeeRepository;
import project.dao.OpportunityRepository;
import project.domain.Employee;
import project.domain.Opportunity;
import project.domain.dto.OpportunityDto;
import project.domain.enums.OpportunityType;
import project.domain.mappers.OpportunityMapper;
import project.exceptions.EntityNotFound;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OpportunityService {

    private final OpportunityRepository opportunityRepository;
    private final EmployeeRepository employeeRepository;
    private final OpportunityMapper opportunityMapper;

    public OpportunityService(OpportunityRepository opportunityRepository, EmployeeRepository employeeRepository, OpportunityMapper opportunityMapper) {
        this.opportunityRepository = opportunityRepository;
        this.employeeRepository = employeeRepository;
        this.opportunityMapper = opportunityMapper;
    }

    @Transactional
    public Opportunity addOpportunity(Opportunity opportunity){
        return opportunityRepository.saveAndFlush(opportunity);
    }

    @Transactional
    public Opportunity editOpportunity(Long id, OpportunityDto opportunityDto) {
        Opportunity opportunity = getOpportunity(id);
        if(opportunity == null){
            throw new EntityNotFound();
        }
        Opportunity updatedOpportunity = opportunityMapper.toOpportunity(opportunityDto, opportunity);
        updatedOpportunity.setId(id);
        Optional<Employee> sales = employeeRepository.findById(opportunityDto.getSalesId());
        if(sales.isPresent()) {
            updatedOpportunity.setSales(sales.get());
        }
        return opportunityRepository.saveAndFlush(updatedOpportunity);
    }

    public List<Opportunity> getOpportunitiesByEmployee(Employee employee){
        return opportunityRepository.findByEmployee(employee);
    }

    public List<Opportunity> getOpportunitiesByType(OpportunityType type){
        return opportunityRepository.findByType(type);
    }

    public List<Opportunity> getOpportunitiesForPeriodOfTime(Date firstBorder, Date secondBorder){
        return opportunityRepository.findForPeriodOfTime(firstBorder, secondBorder);
    }

    public Page<Opportunity> getAllOpportunity(Pageable pageable){
        return opportunityRepository.findAll(pageable);
    }

    public void delete(Long id){
        opportunityRepository.deleteById(id);
    }

    private Opportunity getOpportunity(Long id){
        return opportunityRepository.findById(id).orElseThrow(EntityNotFound::new);
    }
}
