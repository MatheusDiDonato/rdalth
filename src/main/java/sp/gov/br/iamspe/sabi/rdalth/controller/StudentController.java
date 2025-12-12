package sp.gov.br.iamspe.sabi.rdalth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sp.gov.br.iamspe.sabi.rdalth.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public StudentController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/test")
    public ResponseEntity<Student> createTestStudent() {
        Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
        String key = "Student:" + student.getId();
        redisTemplate.opsForValue().set(key, student);
        return ResponseEntity.ok(student);
    }

}
