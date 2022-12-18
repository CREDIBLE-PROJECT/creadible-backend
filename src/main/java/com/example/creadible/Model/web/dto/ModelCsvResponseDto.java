package com.example.creadible.Model.web.dto;

import com.example.creadible.Model.domain.entity.Model;
import lombok.Getter;

@Getter
public class ModelCsvResponseDto {
    private final Long id;
    private final boolean isLearned;
    private final int gender;
    private final int age;
    private final int married;
    private final int dependents;
    private final int education;
    private final int selfEmployed;
    private final int businessType;
    private final int applicantIncome;
    private final int applicantWorkPeriod;
    private final float coapplicantIncome;
    private final float creditHistory;
    private final int creditAmount;
    private final int propertyArea;
    private final int propertyType;
    private final int creditRate;
    private final int loanAmount;
    private final int loanTerm;

    public ModelCsvResponseDto(Model model) {
        this.id = model.getId();
        this.isLearned = model.isLearned();
        this.gender = model.getGender();
        this.age = model.getAge();
        this.married = model.getMarried();
        this.dependents = model.getDependents();
        this.education = model.getEducation();
        this.selfEmployed = model.getSelfEmployed();
        this.businessType = model.getBusinessType();
        this.applicantIncome = model.getApplicantIncome();
        this.applicantWorkPeriod = model.getApplicantWorkPeriod();
        this.coapplicantIncome = model.getCoapplicantIncome();
        this.creditHistory = model.getCreditHistory();
        this.creditAmount = model.getCreditAmount();
        this.propertyArea = model.getPropertyArea();
        this.propertyType = model.getPropertyType();
        this.creditRate = model.getCreditRate();
        this.loanAmount = model.getLoanAmount();
        this.loanTerm = model.getLoanTerm();
    }
}
