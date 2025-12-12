package sp.gov.br.iamspe.sabi.rdalth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CodeTokenDto {
    private String cpf;
    private String token;
}
