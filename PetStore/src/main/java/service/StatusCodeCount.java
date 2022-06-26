package service;

import core.EStatus;

public class StatusCodeCount {

    private EStatus status;

    private int count;


    public StatusCodeCount(EStatus status, int count) {
        this.status = status;
        this.count = count;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
