package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.common.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class SalaryService {

    private static final String NOT_FOUND_MESSAGE = "Salary with id  [ %s ] not found";

    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public Salary get(Long id) {
        try {
            return SalaryMapper.toSalary(salaryRepository.getOne(id));
        } catch (PersistenceException ex) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    public Salary create(Salary salary) {
        return SalaryMapper.toSalary(salaryRepository.save(SalaryMapper.toSalary(salary)));
    }

    public List<SalaryDto> getAll() {
        List<Salary> salarys = SalaryMapper.toSalarysList(salaryRepository.findAll());
        return SalaryMapper.toSalariesDtoList(salarys);
    }

    public List<SalaryDto> getAllByDate() {
        List<Salary> list = SalaryMapper.toSalarysList(salaryRepository.findAllOrderByDateAsc());
        return SalaryMapper.toSalariesDtoList(list);
    }

    public List<Salary> create (List<Salary> listEmploye) {
        List<SalaryEntity> salaryEntities = SalaryMapper.fromSalaryListToEntityList(listEmploye);
        List<SalaryEntity> entities = salaryRepository.saveAll(salaryEntities);
        return SalaryMapper.toSalarysList(entities);
    }
}
