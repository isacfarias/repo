package io.farias.repo.services.employee;

import io.farias.repo.domain.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    private static List<Employee> employees = new ArrayList<>();
    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employees.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst()
                .orElse(new Employee());
    }

    @Override
    public void deleteViaId(long id) {
        employees.stream()
                .filter(employee -> id == employee.getId())
                .findFirst()
                .ifPresent(v -> employees.remove(v));
    }
}
