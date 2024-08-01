package TaskService;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final List<Task> taskList;

    public TaskService() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(String taskId, String name, String description) {
        // Check if the task ID is unique
        if (isTaskIdUnique(taskId)) {
            Task newTask = new Task(taskId, name, description);
            taskList.add(newTask);
        } else {
            throw new IllegalArgumentException("Task ID must be unique.");
        }
    }

    public void deleteTask(String taskId) {
        taskList.removeIf(task -> task.getTaskId().equals(taskId));
    }

    public void updateTaskName(String taskId, String newName) {
        Task taskToUpdate = getTaskById(taskId);
        if (taskToUpdate != null) {
            taskToUpdate.setName(newName);
        } else {
            throw new IllegalArgumentException("Task ID not found.");
        }
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        Task taskToUpdate = getTaskById(taskId);
        if (taskToUpdate != null) {
            taskToUpdate.setDescription(newDescription);
        } else {
            throw new IllegalArgumentException("Task ID not found.");
        }
    }

    private boolean isTaskIdUnique(String taskId) {
        return taskList.stream().noneMatch(task -> task.getTaskId().equals(taskId));
    }

    private Task getTaskById(String taskId) {
        return taskList.stream().filter(task -> task.getTaskId().equals(taskId)).findFirst().orElse(null);
    }

    public boolean taskExists(String taskId) {
        return taskList.stream().anyMatch(task -> task.getTaskId().equals(taskId));
    }

    public String getTaskName(String taskId) {
        Task task = getTaskById(taskId);
        if (task != null) {
            return task.getName();
        } else {
            throw new IllegalArgumentException("Task ID not found.");
        }
    }

    public String getTaskDescription(String taskId) {
        Task task = getTaskById(taskId);
        if (task != null) {
            return task.getDescription();
        } else {
            throw new IllegalArgumentException("Task ID not found.");
        }
    }
}
