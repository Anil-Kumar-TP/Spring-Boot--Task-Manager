package com.anil.taskapp.mappers.impl;

import com.anil.taskapp.domain.dto.TaskListDto;
import com.anil.taskapp.domain.entities.Task;
import com.anil.taskapp.domain.entities.TaskList;
import com.anil.taskapp.domain.entities.TaskStatus;
import com.anil.taskapp.mappers.TaskListMapper;
import com.anil.taskapp.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(taskListDto.id(), taskListDto.title(), taskListDto.description(), Optional.ofNullable(taskListDto.tasks()).map(tasks->tasks.stream().map(taskMapper::fromDto).toList()).orElse(null),null,null);
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(taskList.getId(),taskList.toString(),taskList.getDescription(),Optional.ofNullable(taskList.getTasks()).map(List::size).orElse(0),calculateTaskListProgress(taskList.getTasks()),Optional.ofNullable(taskList.getTasks()).map(tasks -> tasks.stream().map(taskMapper::toDto).toList()).orElse(null));
    }


    private Double calculateTaskListProgress(List<Task> tasks){
        if (tasks == null){
            return null;
        }

        long closedTaskCount = tasks.stream().filter(task -> TaskStatus.CLOSED == task.getStatus()).count();
        return (double) closedTaskCount / tasks.size();
    }
}
