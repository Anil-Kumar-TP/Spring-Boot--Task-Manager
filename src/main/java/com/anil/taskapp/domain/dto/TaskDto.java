package com.anil.taskapp.domain.dto;

import com.anil.taskapp.domain.entities.TaskPriority;
import com.anil.taskapp.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
