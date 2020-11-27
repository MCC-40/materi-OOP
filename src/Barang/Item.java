/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barang;

/**
 *
 * @author Yoshua
 */
public class Item {
    private final Chitato chitato = new Chitato();
    private final Ajinomoto ajinomoto = new Ajinomoto();
    private final Bayclin bayclin = new Bayclin();

    public Chitato getChitato() {
        return chitato;
    }

    public Ajinomoto getAjinomoto() {
        return ajinomoto;
    }

    public Bayclin getBayclin() {
        return bayclin;
    }
}
