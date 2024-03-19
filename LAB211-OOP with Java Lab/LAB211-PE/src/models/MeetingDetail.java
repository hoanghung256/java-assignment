/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hoang hung
 */
public class MeetingDetail {
    private String meetingDetailId;
    private String meetingId;
    private String staffId;
    private String reason;

    public MeetingDetail(String meetingDetailId, String meetingId, String staffId, String reason) {
        this.meetingDetailId = meetingDetailId;
        this.meetingId = meetingId;
        this.staffId = staffId;
        this.reason = reason;
    }

    public String getMeetingDetailId() {
        return meetingDetailId;
    }

    public void setMeetingDetailId(String meetingDetailId) {
        this.meetingDetailId = meetingDetailId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "MeetingDetail{" + "meetingDetailId=" + meetingDetailId + ", meetingId=" + meetingId + ", staffId=" + staffId + ", reason=" + reason + '}';
    }
}
