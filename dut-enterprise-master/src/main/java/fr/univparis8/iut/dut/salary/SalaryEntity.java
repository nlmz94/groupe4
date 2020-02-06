package fr.univparis8.iut.dut.salary;
import fr.univparis8.iut.dut.employee.EmployeeEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "salary", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"monthAndYear", "employee"})
})
public class SalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "montant")
    private double montant;

    @Column(name = "nbJours")
    private int nbJours;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "monthAndYear")
    private String monthAndYear;

    @ManyToOne()
    @JoinColumn(name = "employee")
    private EmployeeEntity employee;

    public SalaryEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getNbJours() {
        return nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employee;
    }

    public void setEmployeeEntity(EmployeeEntity employee) {
        this.employee = employee;
    }

    public String getMonthAndYear() {
        return monthAndYear;
    }

    public void setMonthAndYear(String monthAndYear) {
        this.monthAndYear = monthAndYear;
    }

    public static final class SalaryEntityBuilder {

        private Long id;
        private double montant;
        private int nbJours;
        private LocalDate date;
        private String monthAndYear;
        private EmployeeEntity employee;

        private SalaryEntityBuilder() {
        }

        public static SalaryEntityBuilder create() {
            return new SalaryEntityBuilder();
        }

        public SalaryEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SalaryEntityBuilder withMontant(double montant) {
            this.montant = montant;
            return this;
        }

        public SalaryEntityBuilder withNbJours(int nbJours) {
            this.nbJours = nbJours;
            return this;
        }

        public SalaryEntityBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public SalaryEntityBuilder withMonthAndYear(String monthAndYear) {
            this.monthAndYear = monthAndYear;
            return this;
        }

        public SalaryEntityBuilder withEmployeeEntity(EmployeeEntity employee) {
            this.employee = employee;
            return this;
        }

        public SalaryEntity build() {
            SalaryEntity salaryEntity = new SalaryEntity();
            salaryEntity.setId(id);
            salaryEntity.setMontant(montant);
            salaryEntity.setNbJours(nbJours);
            salaryEntity.setDate(date);
            salaryEntity.setEmployeeEntity(employee);
            salaryEntity.setMonthAndYear(monthAndYear);
            return salaryEntity;
        }
    }
}
















































