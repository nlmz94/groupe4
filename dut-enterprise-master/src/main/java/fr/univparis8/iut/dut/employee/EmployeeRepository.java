package fr.univparis8.iut.dut.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


    @Query("SELECT e FROM EmployeeEntity e ORDER BY e.firstName, e.lastName ASC")
    List<EmployeeEntity> findAllOrderByFirstNameAsc();
}
