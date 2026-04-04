package dev.trovao.clinic_management.exception.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.trovao.clinic_management.exception.model.error.CustomFieldError;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ArgumentNotValidErrorResponse extends ErrorResponse {
        List<CustomFieldError> errors;
}
