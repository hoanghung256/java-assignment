/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hoang hung
 */
public class Staff {
    private String staffId;
    private String departmentId;
    private String staffName;

    public Staff(String staffId, String departmentId, String staffName) {
        this.staffId = staffId;
        this.departmentId = departmentId;
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public String toString() {
        return "Staff [staffId=" + staffId + ", departmentId=" + departmentId + ", staffName=" + staffName + "]";
    }

    public String toFileString() {
        return this.staffId + ";" + this.departmentId + ";" + this.staffName;
    }
}
