package project.service;

import project.dao.OpportunityRepository;
import project.domain.Employee;
import project.domain.Opportunity;
import project.exceptions.EntityNotFound;

import java.time.LocalDate;
import java.util.List;

public class OpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public List<Opportunity> getOpportunitiesByEmployee(Employee employee){
        return opportunityRepository.findByEmployee(employee);
    }

    public List<Opportunity> getOpportunitiesByType(){
        return opportunityRepository.findByType();
    }

    public List<Opportunity> getOpportunitiesForPeriodOfTime(LocalDate firstBorder, LocalDate secondBorder){
        return opportunityRepository.findForPeriodOfTime(firstBorder, secondBorder);
    }

    public List<Opportunity> getAllOpportunity(){
        return opportunityRepository.findAll();
    }

    public void delete(Long id){
        opportunityRepository.delete(id);
    }

    private Opportunity getOpportunity(Long id){
        return opportunityRepository.findById(id).orElseThrow(EntityNotFound::new);
    }
}
