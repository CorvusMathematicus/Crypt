/*
 * Copyright (C) 2015 korppi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logic.Logic;

/**
 *
 * @author korppi
 *
 * Luokka ilmentää näppäimistön kuuntelijaa (KeyListener)
 */
public class KeyInput implements KeyListener {

    final private Logic l;

    /**
     *
     * @param l käytettävä ohjelmalogiikka
     */
    public KeyInput(Logic l) {
        this.l = l;
    }

    /**
     * Metodia ei käytetä, se ei tee mitään.
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Metodia ei käytetä, se ei tee mitään.
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Metodi reagoi näppäimistöllä kirjoitettun merkkiin
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        l.input(e.getKeyChar());
    }
}
