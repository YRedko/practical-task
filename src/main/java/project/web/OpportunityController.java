package project.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import project.domain.Employee;
import project.domain.Opportunity;
import project.domain.dto.OpportunityDto;
import project.domain.enums.OpportunityType;
import project.domain.mappers.OpportunityMapper;
import project.service.OpportunityService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunityController {

    private final OpportunityService opportunityService;
    private final HttpSession httpSession;
    private final OpportunityMapper opportunityMapper;

    public OpportunityController(OpportunityService opportunityService, HttpSession httpSession, OpportunityMapper opportunityMapper) {
        this.opportunityService = opportunityService;
        this.httpSession = httpSession;
        this.opportunityMapper = opportunityMapper;
    }

    @PostMapping("/create")
    public Opportunity create(@Valid OpportunityDto opportunityDto) {
        return opportunityService.addOpportunity(opportunityMapper.toNewOpportunity(opportunityDto));
    }

    @PutMapping("/{id}")
    public Opportunity update(@PathVariable("id") Long id, @Valid @RequestBody OpportunityDto opportunityDto) {
        return opportunityService.editOpportunity(id, opportunityDto);
    }

    @GetMapping("/byEmployee/{id}")
    public List<Opportunity> opportunitiesByEmployee(@PathVariable("id") Employee employee){
        return opportunityService.getOpportunitiesByEmployee(employee);
    }

    @GetMapping("/byType")
    public List<Opportunity> opportunitiesByType(OpportunityType type){
        return opportunityService.getOpportunitiesByType(type);
    }

    @GetMapping("/forPeriodOfTime")
    public List<Opportunity> opportunitiesForPeriodOfTime(String firstBorder, String secondBorder)throws Exception{
        return opportunityService.getOpportunitiesForPeriodOfTime(parseDate(firstBorder), parseDate(secondBorder));
    }

    @GetMapping("/all")
    public Page<Opportunity> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return opportunityService.getAllOpportunity(pageable);
    }

    @PostMapping("/delete")
    public void delete(Long id){ opportunityService.delete(id);}

    private Date parseDate(String date)throws Exception{
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    private Employee getUser(){
        return (Employee) httpSession.getAttribute("user");
    }
}
