package fr.univparis8.iut.dut.vacation;

import java.util.List;
import java.util.stream.Collectors;

public final class VacationMapper {

    public static VacationDto toVacationDto ( Vacation vacation ) {
        return VacationDto.VacationDtoBuilder.create()
                .withId(vacation.getId())
                .withDateStart(vacation.getDateStart())
                .withDateEnd(vacation.getDateStart())
                .withIdEmployee(vacation.getIdEmployee())
                .build();
    }

    public static Vacation toVacation ( VacationDto vacation ) {
        return Vacation.VacationBuilder.create()
                .withId(vacation.getId())
                .withDateStart(vacation.getDateStart())
                .withDateEnd(vacation.getDateStart())
                .withIdEmployee(vacation.getIdEmployee())
                .build();

    }

    public static Vacation toVacation ( VacationEntity vacation ) {
        return Vacation.VacationBuilder.create()
                .withId(vacation.getId())
                .withDateStart(vacation.getDateStart())
                .withDateEnd(vacation.getDateStart())
                .withIdEmployee(vacation.getIdEmployee())
                .build();
    }

    public static VacationEntity toVacation  ( Vacation vacation ) {
        return VacationEntity.VacationEntityBuilder.create()
                .withId(vacation.getId())
                .withDateStart(vacation.getDateStart())
                .withDateEnd(vacation.getDateStart())
                .withIdEmployee(vacation.getIdEmployee())
                .build();
    }

    public static List<Vacation> toVacationsList(List<VacationEntity> vacationEntities) {
        return vacationEntities.stream()
                .map(VacationMapper::toVacation)
                .collect(Collectors.toList());
    }

    public static List<VacationDto> toSalariesDtoList(List<Vacation> vacation) {
        return vacation.stream()
                .map(VacationMapper::toVacationDto)
                .collect(Collectors.toList());
    }

    public static List<VacationEntity> fromVacationListToEntityList( List<Vacation> listVacation ){
        return listVacation.stream()
                .map(VacationMapper::toVacation)
                .collect(Collectors.toList());
    }

    public static List<Vacation> fromDtoListToVacationsList(List<VacationDto> listVacationDto) {
        return listVacationDto.stream()
                .map(VacationMapper::toVacation)
                .collect(Collectors.toList());
    }



}
