package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {
    private Appointment appointment;
    private Date futureDate;

    @BeforeEach
    void setUp() {
        futureDate = new Date(System.currentTimeMillis() + 100000);
        appointment = new Appointment("1234567890", futureDate, "Description");
    }

    @Test
    void testAppointmentCreation() {
        assertNotNull(appointment);
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Description", appointment.getDescription());
    }

    @Test
    void testAppointmentIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    void testAppointmentDateInPast() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Description");
        });
    }

    @Test
    void testAppointmentDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, "This description is definitely longer than fifty characters.");
        });
    }

    @Test
    void testSetDescription() {
        appointment.setDescription("New Description");
        assertEquals("New Description", appointment.getDescription());
    }

    @Test
    void testSetDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription("This description is definitely longer than fifty characters.");
        });
    }
}
