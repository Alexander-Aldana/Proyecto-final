package com.devsenir.jaldana.model;

public class UserHistorial {
    private String description;
    private long time;
    //creacion del constructor
    public UserHistorial (String description) {
        this.description = description;
        this.time = System.currentTimeMillis();
    }
    //metodo accesor get para obtener la descripcion
    public String getDescription() {
        return description;
    }
    //Metodo accesor get para hobtener la hora en la que ocurrio la accion
    public long getTime() {
        return time;
    }    
}
