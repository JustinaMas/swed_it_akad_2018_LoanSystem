package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;

import java.util.Comparator;

public class PrioritizedListComparator implements Comparator<Loan> {

    @Override
    public int compare(Loan o1, Loan o2) {
//
//        o1.getRiskType()
//        if (o1.getRiskType() == LoanRiskType.HIGH_RISK && o2.getRiskType() != LoanRiskType.HIGH_RISK) return -1;
//        if (o2.getRiskType() == LoanRiskType.HIGH_RISK && o1.getRiskType() != LoanRiskType.HIGH_RISK) return 1;
//        if (o1.getRiskType() == LoanRiskType.NORMAL_RISK && o2.getRiskType() != LoanRiskType.NORMAL_RISK) return -1;
//        if (o2.getRiskType() == LoanRiskType.NORMAL_RISK && o1.getRiskType() != LoanRiskType.NORMAL_RISK) return 1;
//        if (o1.calculateTotalLoanCost().compareTo(o2.calculateTotalLoanCost()) > 0) return -1;
//        if (o1.calculateTotalLoanCost().compareTo(o2.calculateTotalLoanCost()) < 0) return 1;
//        if (o1.getCreationDate().before(o2.getCreationDate())) return -1;
//        if (o2.getCreationDate().before(o1.getCreationDate())) return 1;
      return 0;
    }
}
