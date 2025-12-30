package org.hospital;

public class HospitalSystemApp {

    private String patientName;
    private int urgencyLevel;
    private String status;
    private String doctor;
    private String nurse;
    private String room;
    private int waitingTime;
    private int treatmentTime;
    private boolean emergency;

    public HospitalSystemApp() {
    }

    public HospitalSystemApp(String patientName, int urgencyLevel, String status, String doctor, String nurse, String room, int waitingTime, int treatmentTime, boolean emergency) {
        this.patientName = patientName;
        this.urgencyLevel = urgencyLevel;
        this.status = status;
        this.doctor = doctor;
        this.nurse = nurse;
        this.room = room;
        this.waitingTime = waitingTime;
        this.treatmentTime = treatmentTime;
        this.emergency = emergency;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(int urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(int treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}
