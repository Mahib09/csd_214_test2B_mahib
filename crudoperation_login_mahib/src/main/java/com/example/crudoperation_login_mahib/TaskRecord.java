package com.example.crudoperation_login_mahib;

public class TaskRecord {
    private int task_id;
    private String task_name;
    private String task_description;
    private String task_status;

    public TaskRecord(int task_id, String task_name, String task_description, String task_status){
        this.task_id=task_id;
        this.task_name=task_name;
        this.task_description=task_description;
        this.task_status=task_status;

    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }
}
