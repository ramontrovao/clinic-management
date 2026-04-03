package dev.trovao.clinic_management.exception.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record ErrorResponse(
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime timestamp,
        int code,
        String status,
        String path,
        List<String> errors
) {}
