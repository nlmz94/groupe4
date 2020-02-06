package fr.univparis8.iut.dut.vacation;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;


public class VacationDto {

    private int id;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int idEmployee;

    public VacationDto( int id, LocalDate deb, LocalDate fin, int idemp ) {

        this.idEmployee=idemp;
        this.id=id;
        this.dateEnd=fin;
        this.dateStart=deb;

    }

    public VacationDto() {

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

    public static final class VacationDtoBuilder {

        private int id;
        private LocalDate dateStart;
        private LocalDate dateEnd;
        private int idEmployee;

        public VacationDtoBuilder() {
        }

        public static VacationDtoBuilder create() {
            return new VacationDtoBuilder();
        }

        public VacationDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public VacationDtoBuilder withDateStart(LocalDate dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        public VacationDtoBuilder withDateEnd(LocalDate dateEnd) {
            this.dateEnd = dateEnd;
            return this;
        }

        public VacationDtoBuilder withIdEmployee(int idEmployee) {
            this.idEmployee = idEmployee;
            return this;
        }

        public  VacationDto build() {
            return new VacationDto(id, dateStart, dateEnd, idEmployee) ;
        }
    }
}
