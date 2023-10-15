package com.example;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"full_name,birthDate"})
public class Person {
    @JsonProperty("full_name")
    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @JsonIgnore
    private String ssn;

    public Person(String fullName, Date birthDate, String ssn) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.ssn = ssn;
    }

    public Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
