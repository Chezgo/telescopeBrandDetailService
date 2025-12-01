package com.example.telescopeBrandDetailService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Полная информация о бренде детали телескопа")
@Entity
@Table(name = "t_telescope_brand_detail")
public class TelescopeBrandDetail {
    @Schema(description = "Уникальный идентификатор бренда", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telescope_brand_detail")
    private Long id;
    @Schema(description = "Название бренда", example = "Meade")
    @Column(name = "name_telescope_brand_detail")
    private String name;
    @Schema(description = "Описание бренда", example = "Производитель из США")
    private String description;

    public TelescopeBrandDetail(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public TelescopeBrandDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
