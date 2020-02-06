package fr.univparis8.iut.dut.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/salary")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public List<SalaryDto> getAllSalarys() {
        return salaryService.getAll();
    }

    @GetMapping("{id}")
    public SalaryDto getSalary(@PathVariable Long id) {
        return SalaryMapper.toSalaryDto(salaryService.get(id));
    }

    @PostMapping
    public ResponseEntity<SalaryDto> createSalary(@RequestBody SalaryDto salaryDto) throws URISyntaxException {

        if(salaryDto.getId() != null) {
            throw new IllegalArgumentException("Salary id should not be populated when creating and salary");
        }

       //if (salaryDto.getDate().compareTo(salaryDto.getEmployeeDto().getSalaries().get(i));



        Salary newSalary = salaryService.create(SalaryMapper.toSalary(salaryDto));

        URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{id}")
                .buildAndExpand(newSalary.getId())
                .toUri().getPath()
        );

        return ResponseEntity.created(uri).body(SalaryMapper.toSalaryDto(newSalary));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<SalaryDto>> batchCreate (@RequestBody List<SalaryDto> list){
        List<Salary> list1 = SalaryMapper.fromDtoListToSalarysList(list);
        List<Salary> list2 = salaryService.create(list1);
        return ResponseEntity.ok(SalaryMapper.toSalariesDtoList(list2));
    }

    @GetMapping("/ByDate")
    public List<SalaryDto> getAllByDate() {
        return salaryService.getAllByDate();
    }
}
