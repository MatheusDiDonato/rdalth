package sp.gov.br.iamspe.sabi.rdalth.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import sp.gov.br.iamspe.sabi.rdalth.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}

