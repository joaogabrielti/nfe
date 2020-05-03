package dev.joaogabriel.jfiscal.retrofit.receitaws;

public class Billing {
    private boolean free;
    private boolean database;

    public Billing(boolean free, boolean database) {
        this.free = free;
        this.database = database;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isDatabase() {
        return database;
    }

    public void setDatabase(boolean database) {
        this.database = database;
    }
}