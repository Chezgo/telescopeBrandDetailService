package com.example.telescopeBrandDetailService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateTelescopeBrandDetailRequest(
        @Schema(description = "Название бренда", example = "Celestron", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Имя бренда не должно быть null")
        @NotBlank(message = "Имя бренда обязательно для заполнения")
        @Size(min = 3,max = 50, message = "Имя бренда должно быть от 3 до 50 символов")
        String name,

        @Schema(description = "Описание бренда", example = "Американский производитель телескопов", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Описание не должно быть null")
        @NotBlank(message = "Описание обязательно для заполнения")
        @Size(min = 3,max = 255, message = "Описание должно быть от 3 до 255 символов")
        String description
) {}
