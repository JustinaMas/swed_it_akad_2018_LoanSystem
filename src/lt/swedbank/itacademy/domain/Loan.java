package lt.swedbank.itacademy.domain;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Loan {

    private String name;
    private int termInYears;
    private Date creationDate;
    private BigDecimal interestRate;
    private BigDecimal price;
    private LoanRiskType riskType;


    public LoanRiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(LoanRiskType riskType) {
        this.riskType = riskType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTermInYears() {
        return termInYears;
    }

    public void setTermInYears(int termInYears) {
        this.termInYears = termInYears;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return termInYears == loan.termInYears &&
                Objects.equals(name, loan.name) &&
                Objects.equals(creationDate, loan.creationDate) &&
                Objects.equals(interestRate, loan.interestRate) &&
                Objects.equals(price, loan.price) &&
                riskType == loan.riskType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, termInYears, creationDate, interestRate, price, riskType);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "name='" + name + '\'' +
                ", termInYears=" + termInYears +
                ", creationDate=" + creationDate +
                ", interestRate=" + interestRate +
                ", price=" + price +
                ", riskType=" + riskType +
                '}';
    }
}
