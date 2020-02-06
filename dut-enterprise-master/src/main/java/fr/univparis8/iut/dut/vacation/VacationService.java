package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.common.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class VacationService {

    private static final String NOT_FOUND_MESSAGE = "Vacation with id  [ %s ] not found";

    private final VacationRepository vacationRepository;

    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    public Vacation get(Long id) {
        try {
            return VacationMapper.toVacation(vacationRepository.getOne(id));
        } catch (PersistenceException ex) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    public Vacation create(Vacation vacation) {
        return VacationMapper.toVacation(vacationRepository.save(VacationMapper.toVacation(vacation)));
    }

    public List<VacationDto> getAll() {
        List<Vacation> vacations = VacationMapper.toVacationsList(vacationRepository.findAll());
        return VacationMapper.toSalariesDtoList(vacations);
    }

    public List<VacationDto> getAllByDate() {
        List<Vacation> list = VacationMapper.toVacationsList(vacationRepository.findAllOrderByDateAsc());
        return VacationMapper.toSalariesDtoList(list);
    }

    public List<Vacation> create (List<Vacation> listEmploye) {
        List<VacationEntity> vacationEntities = VacationMapper.fromVacationListToEntityList(listEmploye);
        List<VacationEntity> entities = vacationRepository.saveAll(vacationEntities);
        return VacationMapper.toVacationsList(entities);
    }

    public Vacation update(Vacation vacation) {
      /*  if(!vacationRepository.existsById(vacation.getId())) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, vacation.getId()));
        }
        VacationEntity savedVacation = vacationRepository.save(VacationMapper.toVacation((vacation)));
        return VacationMapper.toVacation(savedVacation); */
      return null;
    }

    public Vacation partialUpdate(Vacation vacation) {
      /*  if(!vacationRepository.existsById(vacation.getId())) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, vacation.getId()));
        }

        Vacation currentVacation = VacationMapper.toVacation(vacationRepository.getOne(vacation.getId()));
        Vacation mergedVacation = currentVacation.mergeWith(vacation);

        VacationEntity newVacation = vacationRepository.save(VacationMapper.toVacation(mergedVacation));

        return VacationMapper.toVacation(newVacation); */
      return  null;
    }

    public void delete(Long id) {
        if(vacationRepository.existsById(id)) {
            vacationRepository.deleteById(id);
        }
    }

}
