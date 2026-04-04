package dev.trovao.clinic_management.exception.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        public LocalDateTime timestamp;
        public int code;
        public String status;
        public String path;
}
