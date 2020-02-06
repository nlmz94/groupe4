package fr.univparis8.iut.dut.salary;
import fr.univparis8.iut.dut.employee.Employee;
import java.time.LocalDate;

public class Salary {

    private final Long id;
    private final double montant;
    public final int nbJours;
    private final LocalDate date;
    private final String monthAndYear;
    private final Employee employee;

    public Salary(Long id, int nbJours, LocalDate date, String monthAndYear, Employee employee ) {
        this.id = id ;
        this.montant=calculateSalary(nbJours) ;
        this.nbJours = nbJours ;
        this.date = date ;
        this.monthAndYear = monthAndYear ;
        this.employee = employee ;
    }

    public Long getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }

    public int getNbJours() {
        return nbJours;
    }

    public LocalDate getDate() {
        return date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getMonthAndYear() {
        return monthAndYear;
    }

    private static double calculateSalary( int nbJours  ) {
        return ( 2000 * nbJours ) / 20 ;
    }

    public static final class SalaryBuilder {
        private Long id;
        private double montant;
        private int nbJours;
        private LocalDate date;
        private String monthAndYear;
        private Employee employee;

        private SalaryBuilder() {
        }

        public static SalaryBuilder create() {
            return new SalaryBuilder();
        }

        public SalaryBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SalaryBuilder withMontant(double montant) {
            this.montant = montant;
            return this;
        }

        public SalaryBuilder withNbJours(int nbJours) {
            this.nbJours = nbJours;
            return this;
        }

        public SalaryBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public SalaryBuilder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public SalaryBuilder withMonthAndYear(String monthAndYear) {
            this.monthAndYear = monthAndYear;
            return this;
        }

        public  Salary build() {
            return new Salary(id, nbJours, date ,monthAndYear , employee );
        }
    }
}





















