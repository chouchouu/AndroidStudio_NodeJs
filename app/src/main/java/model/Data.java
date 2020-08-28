package model;

import java.util.List;

public class Data {
    private boolean status;
    private List<buy> data;

    public Data() {
    }

    public Data(boolean status, List<buy> data) {
        this.status = status;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<buy> getData() {
        return data;
    }

    public void setData(List<buy> data) {
        this.data = data;
    }
}
