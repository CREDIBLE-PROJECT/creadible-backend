package com.example.creadible.User.web.dto;

import lombok.Getter;

@Getter
public class UserScoreResponseDto {
    private final String name;
    private final int score;
    //대출 금액
    private final double loanAmountPercent;
    private final long loanAmount;
    //상위 몇퍼센트
    private final double percent;
    //대출중인 금액
    private final long creditAmount;
    private final double creditAmountPercent;
    //주거지 소유 여부
    private final int propertyType; //(1.자가, 2.월세, 3.전세, 4.기타)
    private final double propertyTypePercent;
    //대출 신청인 수입
    private final long applicantIncome;
    private final double applicantIncomePercent;
    //대출 이용 횟수
    private final long creditHistory;
    private final double creditHistoryPercent;
    //근무 기간
    private final long applicantWorkPeriod;
    private final double applicantWorkPeriodPercent;
    //상환 기간
    private final long loanTerm;
    private final double loanTermPercent;
    //대출 심사 예측
    private final int predict;

    public UserScoreResponseDto(String name, int score, double loanAmountPercent, long loanAmount, double percent, long creditAmount, double creditAmountPercent, int propertyType, double propertyTypePercent, long applicantIncome, double applicantIncomePercent, long creditHistory, double creditHistoryPercent, long applicantWorkPeriod, double applicantWorkPeriodPercent, long loanTerm, double loanTermPercent, int predict) {
        this.name = name;
        this.score = score;
        this.loanAmountPercent = loanAmountPercent;
        this.loanAmount = loanAmount;
        this.percent = percent;
        this.creditAmount = creditAmount;
        this.creditAmountPercent = creditAmountPercent;
        this.propertyType = propertyType;
        this.propertyTypePercent = propertyTypePercent;
        this.applicantIncome = applicantIncome;
        this.applicantIncomePercent = applicantIncomePercent;
        this.creditHistory = creditHistory;
        this.creditHistoryPercent = creditHistoryPercent;
        this.applicantWorkPeriod = applicantWorkPeriod;
        this.applicantWorkPeriodPercent = applicantWorkPeriodPercent;
        this.loanTerm = loanTerm;
        this.loanTermPercent = loanTermPercent;
        this.predict = predict;
    }
}
