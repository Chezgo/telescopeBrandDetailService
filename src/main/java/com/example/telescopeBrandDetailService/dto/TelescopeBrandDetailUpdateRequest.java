package com.example.telescopeBrandDetailService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TelescopeBrandDetailUpdateRequest(
        @Schema(description = "Обновлённое название бренда", example = "Sky-Watcher", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Имя бренда не должно быть null")
        @NotBlank(message = "Имя бренда обязательно для заполнения")
        @Size(min = 3,max = 50, message = "Имя характеристики должно быть от 3 до 50 символов")
        String name,

        @Schema(description = "Обновлённое описание", example = "Британский бренд с фабрикой в Китае", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Имя бренда не должно быть null")
        @NotBlank(message = "Имя бренда обязательно для заполнения")
        @Size(min = 3,max = 255, message = "Описание должно быть от 3 до 255 символов")
        String description
) {}
