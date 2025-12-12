package sp.gov.br.iamspe.sabi.rdalth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sp.gov.br.iamspe.sabi.rdalth.model.StudentExampleEntity;

@RestController
@RequestMapping("/students")
public class StudentExampleController {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public StudentExampleController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/test")
    public ResponseEntity<StudentExampleEntity> createTestStudent() {
        StudentExampleEntity studentExampleEntity = new StudentExampleEntity("Eng2015001", "John Doe", StudentExampleEntity.Gender.MALE, 1);
        String key = "Student:" + studentExampleEntity.getId();
        redisTemplate.opsForValue().set(key, studentExampleEntity);
        return ResponseEntity.ok(studentExampleEntity);
    }

}
