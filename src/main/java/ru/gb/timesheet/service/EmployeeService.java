package ru.gb.timesheet.service;

import org.springframework.stereotype.Service;
import ru.gb.timesheet.model.Employee;
import ru.gb.timesheet.model.Project;
import ru.gb.timesheet.model.Timesheet;
import ru.gb.timesheet.repository.EmployeeRepository;
import ru.gb.timesheet.repository.ProjectRepository;
import ru.gb.timesheet.repository.TimesheetRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {


        private final ProjectRepository projectRepository;
        private final TimesheetRepository timesheetRepository;
        private  final EmployeeRepository employeeRepository;

        public EmployeeService(ProjectRepository projectRepository, TimesheetRepository timesheetRepository, EmployeeRepository employeeRepository) {
            this.projectRepository = projectRepository;
            this.timesheetRepository = timesheetRepository;
            this.employeeRepository = employeeRepository;
        }

        public Optional<Employee> findById(Long id) {
            return employeeRepository.findById(id);
        }

        public List<Employee> findAll() {
            return employeeRepository.findAll();
        }

        public Employee create(Employee employee) {
            return employeeRepository.save(employee);
        }

        public void delete(Long id) {
            employeeRepository.deleteById(id);
        }

        public List<Timesheet> getTimesheets(Long id) {
            if (employeeRepository.findById(id).isEmpty()) {
                throw new NoSuchElementException("Employee with id = " + id + " does not exists");
            }

            return timesheetRepository.findByEmployeeId(id);
        }
    }


