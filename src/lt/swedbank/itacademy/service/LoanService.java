package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.*;
import lt.swedbank.itacademy.util.DateUtil;


import java.math.BigDecimal;
import java.util.*;

import static lt.swedbank.itacademy.domain.LoanRiskType.*;


public class LoanService implements LoanServiceInterface {

    private Loan[] loans;

    public LoanService(Loan[] loans) {
        this.loans = loans;
    }


   // public BigDecimal getAverageLoanCost() {
   //     return calculateAverageLoanCost();
  //  }

   // public BigDecimal getAverageLoanCost(LoanRiskType riskType) {
   //     return calculateAverageLoanCost(riskType);
  //  }

    private BigDecimal calculateAverageLoanCost(LoanRiskType riskType) {
        BigDecimal averageLoanCost = BigDecimal.ZERO;
        int countOfLoans = 0;
        for (Loan loan : loans) {
            if (loan.getRiskType().equals(riskType)) {
                averageLoanCost = averageLoanCost.add(calculateTotalLoanCost(loan));
                countOfLoans++;
            }
        }
        return averageLoanCost.divide(BigDecimal.valueOf(countOfLoans),BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal calculateInterest(BigDecimal price ,BigDecimal interestRate) {

        return price.multiply(interestRate.divide(BigDecimal.valueOf(100),BigDecimal.ROUND_HALF_UP));
    }

    public BigDecimal calculateNewInterestRate() {
        BigDecimal newInterestRate = BigDecimal.ZERO;
        for (Loan loan : loans) {
            if(loan instanceof VehicleLoan){

              newInterestRate = loan.getInterestRate().multiply(returnCoefficient(loan.getRiskType()));
            }
        }
        return newInterestRate;
    }

    private BigDecimal returnCoefficient(LoanRiskType riskType) {
        switch (riskType) {
            case HIGH_RISK:
                return new BigDecimal(1.5);
            case NORMAL_RISK:
                return new BigDecimal(1.0);
            case LOW_RISK:
                return new BigDecimal(0.8);
            default: throw new IllegalArgumentException();
        }
    }
    private BigDecimal calculateAverageInterestRate(){
        BigDecimal averageInterestRate = BigDecimal.ZERO;
        int counter = 0;
        for (Loan loan:loans) {
            if(loan instanceof VehicleLoan){
                counter++;
              averageInterestRate = averageInterestRate.add(calculateNewInterestRate());
            }
        }
        return averageInterestRate.divide(BigDecimal.valueOf(counter),BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal calculateTotalLoanCost(Loan loan) {

        return loan.getPrice().add(calculateInterest(loan.getPrice(),loan.getInterestRate()));
    }


    private BigDecimal calculateAverageLoanCost() {
        BigDecimal averageLoanCost = BigDecimal.ZERO;
        for (Loan loan : loans) {
            averageLoanCost = averageLoanCost.add(calculateTotalLoanCost(loan));
        }
        return averageLoanCost.divide(BigDecimal.valueOf(loans.length), BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal calculateMaximumPriceOfNonExpiredLoans() {
        BigDecimal maximum = BigDecimal.ZERO;
        for (Loan loan : loans) {
            if (isValid(loan)) {
                if (maximum.compareTo(loan.getPrice()) < 0) {
                    maximum = loan.getPrice();
                }
            }
        }
        return maximum;
    }

    private boolean isValid(Loan loan) {
        Date expirationDate;
        expirationDate = DateUtil.addYears(loan.getCreationDate(), loan.getTermInYears());
        return expirationDate.getTime() > new Date().getTime();
    }


    public List<Loan> findHighRiskLoans() {

        List<Loan> highRisks = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getRiskType() == HIGH_RISK) {
                highRisks.add(loan);
            }
        }
        return highRisks;
    }

    private List<Loan> findRiskLoans(LoanRiskType riskType) {

        List<Loan> risks = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getRiskType() == riskType) {
                risks.add(loan);
            }
        }
        return risks;
    }


    public Set<String> findVehicleModels() {
        Set<String> models = new HashSet<>();
        for (Loan loans : loans) {
            if (loans instanceof VehicleLoan) {
                models.add(((VehicleLoan) loans).getModel());
            }
        }
        return models;

    }

    public Map<LoanRiskType, List<Loan>> groupLoansByRiskType() {
        Map<LoanRiskType, List<Loan>> loansGroupedByRiskType = new HashMap<>();
        for (LoanRiskType riskType : LoanRiskType.values()) {
            loansGroupedByRiskType.put(riskType, findRiskLoans(riskType));
        }
        return loansGroupedByRiskType;
    }

    public List<Loan> getLowRiskHarvesterLoans() {
        List<Loan> lowRiskHarvesterLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan instanceof HarvesterLoan && loan.getRiskType().equals(LoanRiskType.LOW_RISK)) {
                lowRiskHarvesterLoans.add(loan);
            }
        }
        return lowRiskHarvesterLoans;
    }

    public List<Loan> getExpiredLandLoansInReservation() {
        List<Loan> expiredLoansInReservation = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan instanceof LandLoan && !isValid(loan)) {
                expiredLoansInReservation.add(loan);
            }
        }
        return expiredLoansInReservation;
    }

    public List<Loan> getLoansOfHigherThanAverageDepreciation() {
        List<Loan> higherThanAverageLoans = new ArrayList<>();

//        for (:) {
//
//        }
        return higherThanAverageLoans;
    }
    public  Set<Loan> prioritizeLoans(){
        Set <Loan> prioritizedLoans = new HashSet<>( new PrioritizedListComparator());
        for (Loan loan: loans) {
            if(loan.getRiskType() == LoanRiskType.HIGH_RISK){

            }
        }

    }
}
