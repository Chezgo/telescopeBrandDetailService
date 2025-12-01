package com.example.telescopeBrandDetailService.dto;

public final class ApiErrorExamples {

    public static final String VALIDATION_ERROR = """
        {
          "error": "Validation Failed",
          "errorMessage": {
            "name": "Имя бренда не должно быть null"
          }
        }
        """;

    public static final String CONFLICT_ERROR = """
        {
          "error": "Conflict",
          "errorMessage": {
            "message": "Бренд детали телескопа с таким именем уже существует"
          }
        }
        """;

    public static final String NOT_FOUND_ERROR = """
        {
          "error": "Not Found",
          "errorMessage": {
            "message": "Бренд не найден"
          }
        }
        """;

    public static final String UNAUTHORIZED_ERROR = """
        {
          "error": "Authorization error",
          "errorMessage": {
            "message": "Ошибка авторизации"
          }
        }
        """;

    public static final String FORBIDDEN_ERROR = """
        {
          "error": "Forbidden",
          "errorMessage": {
            "message": "Ошибка доступа"
          }
        }
        """;

    private ApiErrorExamples() {}
}