package sp.gov.br.iamspe.sabi.rdalth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sp.gov.br.iamspe.sabi.rdalth.dto.CodeTokenDto;

import java.security.SecureRandom;
import java.time.Duration;

@RestController
@RequestMapping("/token")
public class CpfController {

    private final StringRedisTemplate redisTemplate;
    private static final Duration TTL = Duration.ofMinutes(5);
    private final SecureRandom random = new SecureRandom();

    @Autowired
    public CpfController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/{cpf}")
    public ResponseEntity<CodeTokenDto> saveCpf(@PathVariable("cpf") String cpf) {
        String key = "cpf:" + cpf;
        if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            redisTemplate.delete(key);
        }
        String code = String.format("%06d", random.nextInt(1_000_000));
        redisTemplate.opsForValue().set(key, code, TTL);
        return ResponseEntity.ok(CodeTokenDto.builder().cpf(cpf).token(code).build());
    }


    @GetMapping("/verify")
    public ResponseEntity getCode(@RequestBody CodeTokenDto request) {
        String key = "cpf:" + request.getCpf();
        String code = redisTemplate.opsForValue().get(key);
        if (code != null && request.getToken() != null && code.equals(request.getToken())) {
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
        }
    }

}
