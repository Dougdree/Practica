package com.unl.practica2.base.controller.dao.dato_models;

import java.util.Date;

import com.unl.practica2.base.controller.dao.AdapterDao;
import com.unl.practica2.base.domain.models.Banda;

public class DaoBanda extends AdapterDao<Banda> {
    private Banda obj;

    public DaoBanda() {
        super(Banda.class);
        // TODO Auto-generated constructor stub
    }

    public Banda getObj() {
        if (obj == null)
            this.obj = new Banda();
        return this.obj;
    }

    public void setObj(Banda obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            obj.setId(listAll().getLength()+1);
            this.persist(obj);
            return true;
        } catch (Exception e) {
            //TODO
            return false;
            // TODO: handle exception
        }
    }

    public Boolean update(Integer pos) {
        try {
            this.update(obj, pos);
            return true;
        } catch (Exception e) {
            //TODO
            return false;
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        DaoBanda da = new DaoBanda();
        da.getObj().setId(da.listAll().getLength() + 1);
        da.getObj().setNombre("ShawnMendes");
        da.getObj().setFecha(new Date());
        if (da.save())
            System.out.println("GUARDADO");
        else
            System.out.println("Hubo un error");
        da.setObj(null);
        da.getObj().setId(da.listAll().getLength() + 1);
        da.getObj().setNombre("Chase Atlantic");
        da.getObj().setFecha(new Date());
        if (da.save())
            System.out.println("GUARDADO");
        else
            System.out.println("Hubo un error");
    }

    
}