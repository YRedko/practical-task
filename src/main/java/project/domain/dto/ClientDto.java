package project.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientDto {
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @Size(min = 2, max = 20)
    private String contactName;
    @NotNull
    @Size(min = 2, max = 30)
    private String contactEmail;
    @Size(min = 2, max = 20)
    private String contactPhone;
    @Size(min = 2, max = 255)
    private String contactDetail;

    public ClientDto(){}

    public ClientDto(String name, String contactName, String contactEmail, String contactPhone, String contactDetail) {
        this.name = name;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactDetail = contactDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }
}
