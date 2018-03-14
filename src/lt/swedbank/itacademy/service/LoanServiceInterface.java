package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;

import java.util.List;

public interface LoanServiceInterface {

   public List<Loan> getLowRiskHarvesterLoans();

   public List<Loan> getExpiredLandLoansInReservation();
   public List<Loan> getLoansOfHigherThanAverageDepreciation();
}
