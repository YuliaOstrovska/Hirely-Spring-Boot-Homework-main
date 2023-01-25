package pl.hirely.springboot.company.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.hirely.springboot.company.model.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}