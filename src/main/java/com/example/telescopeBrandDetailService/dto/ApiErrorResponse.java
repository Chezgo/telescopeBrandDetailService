package com.example.telescopeBrandDetailService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.Map;

@Schema(description = "Стандартный формат ответа при ошибке")
public class ApiErrorResponse {

    @Schema(
            description = "Категория ошибки (например, 'Validation Failed', 'Not Found', 'Conflict')",
            example = "Validation Failed"
    )
    private String error;

    @Schema(
            description = "Детали ошибки в виде пар 'ключ → сообщение'. " +
                    "При валидации: ключи — имена полей. " +
                    "При других ошибках: обычно один ключ 'message'.",
            example = "{ \"name\": \"Имя бренда не должно быть null\" }"
    )
    private Map<String, String> errorMessage;

    public String getError() {
        return error;
    }

    public Map<String, String> getErrorMessage() {
        return errorMessage;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setErrorMessage(Map<String, String> errorMessage) {
        this.errorMessage = errorMessage;
    }
}