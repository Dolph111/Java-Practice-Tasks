package com.task;

public class RentedFilm {
    private final String name;
    private final DateTime dataTimeTakeFilm;
    private final DateTime dataTimeReturnFil;

    public RentedFilm(String name, DateTime dataTimeTakeFilm, DateTime dataTimeReturnFil) {
        this.name = name;
        this.dataTimeTakeFilm = dataTimeTakeFilm;
        this.dataTimeReturnFil = dataTimeReturnFil;
    }
    public DateTime getTimeOfRent() {
        return dataTimeTakeFilm;
    }

    public DateTime getTimeOfReturn() {
        return dataTimeReturnFil;
    }

}
