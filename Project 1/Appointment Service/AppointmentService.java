package AppointmentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentService {
    private final List<Appointment> appointmentList;

    public AppointmentService() {
        this.appointmentList = new ArrayList<>();
    }

    public void addAppointment(String appointmentId, Date appointmentDate, String description) {
        if (isAppointmentIdUnique(appointmentId)) {
            Appointment newAppointment = new Appointment(appointmentId, appointmentDate, description);
            appointmentList.add(newAppointment);
        } else {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }
    }

    public void deleteAppointment(String appointmentId) {
        appointmentList.removeIf(appointment -> appointment.getAppointmentId().equals(appointmentId));
    }

    public void updateAppointmentDescription(String appointmentId, String newDescription) {
        Appointment appointmentToUpdate = getAppointmentById(appointmentId);
        if (appointmentToUpdate != null) {
            appointmentToUpdate.setDescription(newDescription);
        } else {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
    }

    private boolean isAppointmentIdUnique(String appointmentId) {
        return appointmentList.stream().noneMatch(appointment -> appointment.getAppointmentId().equals(appointmentId));
    }

    private Appointment getAppointmentById(String appointmentId) {
        return appointmentList.stream().filter(appointment -> appointment.getAppointmentId().equals(appointmentId)).findFirst().orElse(null);
    }

    public List<Appointment> getAppointmentList() {
        return new ArrayList<>(appointmentList);
    }
}
