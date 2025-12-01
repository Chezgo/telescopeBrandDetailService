package com.example.telescopeBrandDetailService.controller;

import com.example.telescopeBrandDetailService.dto.ApiErrorResponse;
import com.example.telescopeBrandDetailService.dto.ApiErrorExamples;
import com.example.telescopeBrandDetailService.dto.CreateTelescopeBrandDetailRequest;
import com.example.telescopeBrandDetailService.dto.TelescopeBrandDetailUpdateRequest;
import com.example.telescopeBrandDetailService.model.TelescopeBrandDetail;
import com.example.telescopeBrandDetailService.service.TelescopeBrandDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "v1/brand-detail")
@Tag(name = "telescopeBrandDetailService", description = "Сервис для управления бизнес сущностью Бренд детали")
public class TelescopeBrandDetailController {

    private final TelescopeBrandDetailService telescopeBrandDetailService;

    public TelescopeBrandDetailController(TelescopeBrandDetailService telescopeBrandDetailService) {
        this.telescopeBrandDetailService = telescopeBrandDetailService;
    }

    @Operation(summary = "Получить все бренды деталей телескопов")
    @ApiResponse(
            responseCode = "200",
            description = "Список брендов успешно получен",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = TelescopeBrandDetail.class))
            )
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamples.UNAUTHORIZED_ERROR
                    )
            )
    )
    @GetMapping
    public List<TelescopeBrandDetail> findAllTelescopeBrandDetail() {
        return telescopeBrandDetailService.findAllTelescopeBrandDetail();
    }

    @Operation(summary = "Получить бренд детали по ID")
    @ApiResponse(
            responseCode = "200",
            description = "Бренд успешно найден",
            content = @Content(schema = @Schema(implementation = TelescopeBrandDetail.class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamples.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Бренд с указанным ID не найден",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Not Found",
                            value = ApiErrorExamples.NOT_FOUND_ERROR
                    )
            )
    )
    @GetMapping("/{id}")
    public ResponseEntity<TelescopeBrandDetail> getTelescopeBrandDetailById(
            @Parameter(description = "Уникальный идентификатор бренда", example = "1")
            @PathVariable Long id
    )
    {
        TelescopeBrandDetail detail = telescopeBrandDetailService.getTelescopeBrandDetailById(id);
        return ResponseEntity.ok(detail);
    }

    @Operation(summary = "Создать новый бренд детали телескопа")
    @ApiResponse(
            responseCode = "200",
            description = "Бренд успешно создан",
            content = @Content(schema = @Schema(implementation = TelescopeBrandDetail.class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamples.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "403",
            description = "Ошибка доступа",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Forbidden",
                            value = ApiErrorExamples.FORBIDDEN_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "400",
            description = "Ошибки валидации: пустое имя, недопустимая длина и т.п.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Validation Error",
                            value = ApiErrorExamples.VALIDATION_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "409",
            description = "Бренд с таким именем уже существует",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Conflict Error",
                            value = ApiErrorExamples.CONFLICT_ERROR
                    )
            )
    )
    @PostMapping
    public TelescopeBrandDetail createTelescopeBrandDetail(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные для создания бренда",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = CreateTelescopeBrandDetailRequest.class)
                    )
            )
            @Valid @RequestBody CreateTelescopeBrandDetailRequest request
    ) {
        return telescopeBrandDetailService.createTelescopeBrandDetail(request);
    }

    @Operation(summary = "Удалить бренд детали по ID")
    @ApiResponse(
            responseCode = "204",
            description = "Бренд успешно удалён",
            content = @Content() // ← Нет тела!
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamples.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "403",
            description = "Ошибка доступа",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Forbidden",
                            value = ApiErrorExamples.FORBIDDEN_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Бренд с указанным ID не найден",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Not Found",
                            value = ApiErrorExamples.NOT_FOUND_ERROR
                    )
            )
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelescopeBrandDetail(
            @Parameter(description = "Уникальный идентификатор удаляемого бренда", example = "5")
            @PathVariable Long id
    ) {
        telescopeBrandDetailService.deleteTelescopeBrandDetail(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Обновить бренд детали по ID")
    @ApiResponse(
            responseCode = "200",
            description = "Бренд успешно обновлён",
            content = @Content(schema = @Schema(implementation = TelescopeBrandDetail.class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamples.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "403",
            description = "Ошибка доступа",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Forbidden",
                            value = ApiErrorExamples.FORBIDDEN_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "400",
            description = "Ошибки валидации: пустое имя, недопустимая длина и т.п.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Validation Error",
                            value = ApiErrorExamples.VALIDATION_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Бренд с указанным ID не найден",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Not Found",
                            value = ApiErrorExamples.NOT_FOUND_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "409",
            description = "Бренд с таким именем уже существует",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Conflict Error",
                            value = ApiErrorExamples.CONFLICT_ERROR
                    )
            )
    )
    @PutMapping("/{id}")
    public ResponseEntity<TelescopeBrandDetail> updateTelescopeBrandDetail(
            @Parameter(description = "Уникальный идентификатор обновляемого бренда", example = "3")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Обновлённые данные бренда",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = TelescopeBrandDetailUpdateRequest.class)
                    )
            )
            @Valid @RequestBody TelescopeBrandDetailUpdateRequest request
    )
    {
        TelescopeBrandDetail updated = telescopeBrandDetailService.updateTelescopeBrandDetail(id, request);
        return ResponseEntity.ok(updated);
    }
}