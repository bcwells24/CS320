package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
    private AppointmentService appointmentService;
    private Date futureDate;

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
        futureDate = new Date(System.currentTimeMillis() + 100000); // Future date for testing
    }

    @Test
    void testAddAppointment() {
        appointmentService.addAppointment("1234567890", futureDate, "Description");
        assertTrue(appointmentService.getAppointmentList().stream()
                .anyMatch(appointment -> appointment.getAppointmentId().equals("1234567890") &&
                        appointment.getAppointmentDate().equals(futureDate) &&
                        appointment.getDescription().equals("Description")));
    }

    @Test
    void testAddDuplicateAppointmentIdThrowsException() {
        appointmentService.addAppointment("1234567890", futureDate, "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment("1234567890", futureDate, "Another Description");
        });
    }

    @Test
    void testDeleteAppointment() {
        appointmentService.addAppointment("1234567890", futureDate, "Description");
        appointmentService.deleteAppointment("1234567890");
        assertFalse(appointmentService.getAppointmentList().stream()
                .anyMatch(appointment -> appointment.getAppointmentId().equals("1234567890")));
    }

    @Test
    void testUpdateAppointmentDescription() {
        appointmentService.addAppointment("1234567890", futureDate, "Description");
        appointmentService.updateAppointmentDescription("1234567890", "New Description");
        assertEquals("New Description", appointmentService.getAppointmentList().stream()
                .filter(appointment -> appointment.getAppointmentId().equals("1234567890"))
                .findFirst()
                .orElseThrow()
                .getDescription());
    }
}
