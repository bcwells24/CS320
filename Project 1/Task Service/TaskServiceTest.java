package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TaskService.TaskService;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        taskService.addTask("T123", "Task Name", "Task Description");
        assertTrue(taskService.taskExists("T123"));
    }

    @Test
    void testAddDuplicateTaskIdThrowsException() {
        taskService.addTask("T123", "Task Name", "Task Description");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask("T123", "Duplicate Task", "Duplicate Description");
        });
    }

    @Test
    void testDeleteTask() {
        taskService.addTask("T123", "Task Name", "Task Description");
        taskService.deleteTask("T123");
        assertFalse(taskService.taskExists("T123"));
    }

    @Test
    void testDeleteNonExistentTask() {
        taskService.addTask("T123", "Task Name", "Task Description");
        try {
            taskService.deleteTask("T456");
        } catch (Exception e) {
            fail("Threw exception with delete command");
        }
        assertTrue(taskService.taskExists("T123"));
    }

    @Test
    void testUpdateTaskName() {
        taskService.addTask("T123", "Task Name", "Task Description");
        taskService.updateTaskName("T123", "Updated Name");
        assertEquals("Updated Name", taskService.getTaskName("T123"));
    }

    @Test
    void testUpdateTaskDescription() {
        taskService.addTask("T123", "Task Name", "Task Description");
        taskService.updateTaskDescription("T123", "Updated Description");
        assertEquals("Updated Description", taskService.getTaskDescription("T123"));
    }
}