package com.anil.taskapp.mappers;

import com.anil.taskapp.domain.dto.TaskDto;
import com.anil.taskapp.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
