package ru.gb.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.timesheet.model.Employee;
import ru.gb.timesheet.model.Timesheet;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
