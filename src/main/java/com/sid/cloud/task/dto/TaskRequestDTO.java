package com.sid.cloud.task.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    private boolean completed;
}
