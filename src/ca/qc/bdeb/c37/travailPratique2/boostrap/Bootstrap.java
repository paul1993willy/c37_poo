/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.qc.bdeb.c37.travailPratique2.boostrap;

import ca.qc.bdeb.c37.travailPratique2.controllers.ControllerCosmos;

/**
 *
 * @author paulwillyjean
 */
public class Bootstrap {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ControllerCosmos processus;
                processus = new ControllerCosmos();
            }
        });
    }

}
