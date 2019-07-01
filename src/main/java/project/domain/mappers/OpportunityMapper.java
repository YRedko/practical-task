package project.domain.mappers;

import org.springframework.stereotype.Component;
import project.domain.Opportunity;
import project.domain.dto.OpportunityDto;
import project.domain.enums.OpportunityType;

@Component
public class OpportunityMapper {
    
    public Opportunity toNewOpportunity(OpportunityDto opportunityDto) {
        if(opportunityDto == null){
            return null;
        }

        Opportunity opportunity = new Opportunity();

        opportunity.setName(opportunityDto.getName());
        opportunity.setDescription(opportunityDto.getDescription());
        if(opportunityDto.getType() != null) {
            opportunity.setType(OpportunityType.valueOf(opportunityDto.getType()));
        }
        opportunity.setProbability(opportunityDto.getProbability());
        opportunity.setProject(opportunityDto.getProject());
        opportunity.setStart(opportunityDto.getStart());
        opportunity.setEnd(opportunityDto.getEnd());

        return opportunity;
    }

    public OpportunityDto toNewOpportunityDto(Opportunity opportunity) {
        if(opportunity == null){
            return null;
        }

        OpportunityDto opportunityDto = new OpportunityDto();

        opportunityDto.setName(opportunity.getName());
        opportunityDto.setDescription(opportunity.getName());
        opportunityDto.setType(opportunity.getType().name());
        opportunityDto.setProbability(opportunity.getProbability());
        opportunityDto.setProject(opportunity.getProject());
        opportunityDto.setStart(opportunity.getStart());
        opportunityDto.setEnd(opportunity.getEnd());

        return opportunityDto;
    }

    public Opportunity toOpportunity(OpportunityDto opportunityDto, Opportunity opportunity) {
        if(opportunityDto == null) {
            return null;
        }
        if(opportunityDto.getName() != null) {
            opportunity.setName(opportunityDto.getName());
        }
        if(opportunityDto.getDescription() != null) {
            opportunity.setDescription(opportunityDto.getDescription());
        }
        if(opportunityDto.getType() != null) {
            opportunity.setType(OpportunityType.valueOf(opportunityDto.getType()));
        }
        if(opportunityDto.getProbability() >= 0){
            opportunity.setProbability(opportunityDto.getProbability());
        }
        if(opportunityDto.getProject() != null){
            opportunity.setProject(opportunityDto.getProject());
        }
        if(opportunityDto.getStart() != null){
            opportunity.setStart(opportunityDto.getStart());
        }
        if(opportunityDto.getEnd() != null){
            opportunity.setEnd(opportunityDto.getEnd());
        }
        return opportunity;
    }
}
