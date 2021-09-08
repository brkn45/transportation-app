package com.example.singup;

public class SuccessEntity {
    int id;
    Boolean success;

    public SuccessEntity(int id, Boolean success) {

        this.id = id;
        this.success = success;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
