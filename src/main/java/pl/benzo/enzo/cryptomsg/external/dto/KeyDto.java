package pl.benzo.enzo.cryptomsg.external.dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeyDto {
    private boolean isCorrect;
    private String val;
}
