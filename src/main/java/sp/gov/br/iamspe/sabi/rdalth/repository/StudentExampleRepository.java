package sp.gov.br.iamspe.sabi.rdalth.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import sp.gov.br.iamspe.sabi.rdalth.model.StudentExampleEntity;

@Repository
public interface StudentExampleRepository extends CrudRepository<StudentExampleEntity, String> {
}

