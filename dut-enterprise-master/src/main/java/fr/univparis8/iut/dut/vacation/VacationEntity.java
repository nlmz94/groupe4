package fr.univparis8.iut.dut.vacation;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class VacationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int idEmployee;


    public VacationEntity( int id, LocalDate deb, LocalDate fin, int idemp ) {

        this.idEmployee=idemp;
        this.id=id;
        this.dateEnd=fin;
        this.dateStart=deb;

    }

    public VacationEntity() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public static final class VacationEntityBuilder {

        private int id;
        private LocalDate dateStart;
        private LocalDate dateEnd;
        private int idEmployee;

        public VacationEntityBuilder() {
        }

        public static VacationEntityBuilder create() {
            return new VacationEntityBuilder();
        }

        public VacationEntityBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public VacationEntityBuilder withDateStart(LocalDate dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        public VacationEntityBuilder withDateEnd(LocalDate dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        public VacationEntityBuilder withIdEmployee(int idEmployee) {
            this.idEmployee = idEmployee;
            return this;
        }

        public  VacationEntity build() { return new VacationEntity(id, dateStart, dateEnd, idEmployee) ; }
    }
}
