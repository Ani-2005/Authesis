package devPilot.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GlobalException {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}