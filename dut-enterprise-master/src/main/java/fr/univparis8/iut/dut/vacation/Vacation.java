package fr.univparis8.iut.dut.vacation;
import java.time.LocalDate;

public class Vacation {

    private final int id;
    private final LocalDate dateStart;
    private final LocalDate dateEnd;
    private final int idEmployee;

    public Vacation( int id, LocalDate deb, LocalDate fin, int idemp ) {
        this.idEmployee=idemp;
        this.id=id;
        this.dateEnd=fin;
        this.dateStart=deb;
    }



    public int getId() {
        return id;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public static final class VacationBuilder {
        private int id;
        private LocalDate dateStart;
        private LocalDate dateEnd;
        private int idEmployee;

        public VacationBuilder() {
        }

        public static VacationBuilder create() {
            return new VacationBuilder();
        }

        public VacationBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public VacationBuilder withDateStart(LocalDate dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        public VacationBuilder withDateEnd(LocalDate dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        public VacationBuilder withIdEmployee(int idEmployee) {
            this.idEmployee = idEmployee;
            return this;
        }

        public  Vacation build() { return new Vacation(id, dateStart, dateEnd, idEmployee) ; }
    }
}
