package com.example.creadible.User.service.impl;

import com.example.creadible.User.domain.entity.User;
import com.example.creadible.User.domain.repository.UserRepository;
import com.example.creadible.User.service.UserService;
import com.example.creadible.User.web.dto.*;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@RequiredArgsConstructor
@SessionAttributes("member")
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDto signUp(UserSignUpDto userSignUpDto) {
        return new UserResponseDto(userRepository.save(userSignUpDto.toEntity()));
    }

    @Override
    public UserScoreResponseDto calculate(String userName) {
        int score = (int)(Math.random() * 800 + 200);
        //대출 금액
        double loanAmountPercent = Math.random() * 80 + 20;
        long loanAmount = (long)(Math.random() * 80000000 + 20000000);
        //상위 몇퍼센트
        double percent = Math.random() * 100;
        //대출중인 금액
        long creditAmount = (long)(Math.random() * 80000000 + 20000000);
        double creditAmountPercent = Math.random() * 80 + 20;
        //주거지 소유 여부
        int propertyType = (int)(Math.random() * 4 + 1); //(1.자가, 2.월세, 3.전세, 4.기타)
        double propertyTypePercent = Math.random() * 80 + 20;
        //대출 신청인 수입
        long applicantIncome = (long)(Math.random() * 80000000 + 20000000);
        double applicantIncomePercent = Math.random() * 80 + 20;
        //대출 이용 횟수
        long creditHistory = (long)(Math.random() * 10 + 20);
        double creditHistoryPercent = Math.random() * 80 + 20;
        //근무 기간
        long applicantWorkPeriod = (long)(Math.random() * 10 + 20);
        double applicantWorkPeriodPercent = Math.random() * 80 + 20;
        //상환 기간
        long loanTerm = (long)(Math.random() * 10 + 10);
        double loanTermPercent = Math.random() * 80 + 20;
        //대출 심사 예측
        int predict = (int)(Math.random() * 2);
        return new UserScoreResponseDto(userName,score,loanAmountPercent,loanAmount,percent,creditAmount,creditAmountPercent,propertyType,propertyTypePercent,applicantIncome,applicantIncomePercent,creditHistory,creditHistoryPercent,applicantWorkPeriod,applicantWorkPeriodPercent,loanTerm,loanTermPercent,predict);
    }

    @Override
    public UserResponseDto login(UserLoginDto loginDto) {
        return new UserResponseDto(userRepository.findUserByLoginId(loginDto.getLoginId()).get());
    }
}
