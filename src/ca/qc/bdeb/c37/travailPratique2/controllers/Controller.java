/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.controllers;

import ca.qc.bdeb.c37.travailPratique2.models.Model;
import ca.qc.bdeb.c37.travailPratique2.views.View;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author paulwillyjean
 */
abstract public class Controller implements PropertyChangeListener {
    private ArrayList<Model> models;
    private ArrayList<View> views;

    public Controller() {
        this.models = new ArrayList<>();
        this.views = new ArrayList<>();
    }

    /**
     * Informe les vues du controlleur des changements de
     * propriété des modèles
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        for (View view : this.views) {
            view.modelPropertyChange(evt);
        }
    }
    public void addModel(Model model) {
        models.add(model);
        model.addController(this);
    }

    public void removeModel(Model model) {
        models.remove(model);
        model.removeController(this);
    }

    public void addView(View view) {
        views.add(view);
    }

    public void removeView(View view) {
        views.remove(view);
    }

    protected void setModelProperty(String propertyName, Object newValue) {
        for (Model model : this.models) {
            try {
                Method method = model.getClass().getMethod("set" + propertyName,
                        new Class[] {newValue.getClass()});
            } catch (NoSuchMethodException nsme) {
                /*
                * Does nothing because we don't care
                */
            }
        }
    }
}
