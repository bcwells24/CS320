package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TaskService.Task;

class TaskTest {

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task("T123", "Task Name", "Task Description");
    }

    @Test
    void testTaskConstructor() {
        assertEquals("T123", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    void testSetTaskName() {
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
    }

    @Test
    void testSetTaskDescription() {
        task.setDescription("Updated Description");
        assertEquals("Updated Description", task.getDescription());
    }

    @Test
    void testSetTaskNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    void testSetTaskNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setName("This Name Is Too Long");
        });
    }

    @Test
    void testSetTaskDescriptionNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }

    @Test
    void testSetTaskDescriptionTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is way too long and exceeds the allowable limit.");
        });
    }
}
