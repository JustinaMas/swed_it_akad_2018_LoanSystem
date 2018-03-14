package lt.swedbank.itacademy;

import lt.swedbank.itacademy.domain.DomainInitializer;
import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;
import lt.swedbank.itacademy.domain.Task1DomainInitializer;
import lt.swedbank.itacademy.service.LoanService;


public class ClientApp {

//    public static void main(String[] args) {
//
//        Loan[] loans = getInitializer().initializeLoans();
//        LoanService service = new LoanService(loans);
//
//
//        System.out.println(service.getAverageLoanCost());
//
//        for (LoanRiskType loanRiskType : LoanRiskType.values()) {
//            System.out.println(service.getAverageLoanCost(loanRiskType));
//        }
//        System.out.println("Maximum:" + service.calculateMaximumPriceOfNonExpiredLoans() );
//        System.out.println("High risk loans " + service.getHighRiskLoans().size());
//
//    }


    public static DomainInitializer getInitializer() {
        return new Task1DomainInitializer();
    }

}
