package pl.hirely.springboot.company.model.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification
import spock.lang.Subject

@DataJpaTest
class DepartmentRepositorySpec extends Specification {

    @Autowired
    @Subject
    private DepartmentRepository departmentRepository;

    def "should find all departments"() {
        when:
        def actual = departmentRepository.findAll()

        then:
        actual.size() == 2
        actual*.name as Set == ['developers', 'managers'] as Set
    }
}
