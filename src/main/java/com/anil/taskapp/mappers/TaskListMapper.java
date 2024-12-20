package com.anil.taskapp.mappers;

import com.anil.taskapp.domain.dto.TaskListDto;
import com.anil.taskapp.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
