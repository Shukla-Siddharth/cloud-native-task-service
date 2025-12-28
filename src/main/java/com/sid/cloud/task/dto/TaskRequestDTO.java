package com.sid.cloud.task.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {

    private String title;
    private String description;
    private boolean completed;
}
