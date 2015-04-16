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
package logic;

import logic.ciphers.*;
import ui.GUI;

/**
 *
 * @author Kalle J. Ouwehand
 *
 * Luokka sisältää varsinaisen ohjelmalogiikan.
 */
public class Logic {

    private boolean encryptMode;    //True=Salataan, False=Puretaan
    private boolean keyBeingSet;
    private int activeCipher;
    final private Cipher cipher[];
    final private GUI gui;
    String plaintext;
    String ciphertext;
    String keytext;
    final private Caesar c;

    public Logic(GUI gui) {
        //Alustus
        this.gui = gui;
        this.activeCipher = 1;
        this.c = new Caesar();
        this.cipher = new Cipher[]{new Atbash(), c, new Vignere(c), new Autokey(c), new OTP(c)};
        this.plaintext = "";
        this.ciphertext = "";
        this.keytext = "";
    }

    /**
     * Metodilla asetetaan ohjelman tila.
     *
     * @param mode True=salaustila, False=purkutila
     */
    public void setEncryptMode(boolean mode) {
        encryptMode = mode;
        /*if (this.activeCipher == 4) {
            if (this.encryptMode == true) {
                gui.disableKey();
            } else {
                gui.enableKey();
            }
        } else if (this.activeCipher != 0) {
            gui.enableKey();
        }*/
    }

    /**
     * Metodi palauttaa onko ohjelma salaus- vai purkutilassa
     *
     * @return encryptMode
     */
    public boolean getEncryptMode() {
        return encryptMode;
    }

    /**
     * Metodi asettaa käytettävän salauksen. Salaus annetaan numerona.
     * 0=Caesar-salaus
     *
     * @param cipherNumber Käytettävän salauksen numero
     */
    public void setCipher(int cipherNumber) {
        activeCipher = cipherNumber;
        keytext = new String(cipher[activeCipher].getKey());
        if (cipherNumber == 0 /*|| (cipherNumber == 4 && this.encryptMode == true)*/) {
            gui.disableKey();
        } else {
            gui.enableKey();
        }
        gui.writeKey(keytext);
    }

    /**
     * Metodi kutsuu käytössä olevan salauksen preEncrypt-metodia.
     *
     * @see logic.ciphers.Cipher
     *
     * @param c Salattava merkki
     * @return cipher Salattu merkki
     */
    public char encrypt(char c) {
        return cipher[activeCipher].preEncrypt(c);
    }

    /**
     * Metodi kutsuu käytössä olevan salauksen preDecrypt-metodia.
     *
     * @see logic.ciphers.Cipher
     *
     * @param c Salattu merkki
     * @return plain Purettu merkki
     */
    public char decrypt(char c) {
        return cipher[activeCipher].preDecrypt(c);
    }

    /**
     * Metodi asettaa ohjelman tilaan, jossa avainta voidaan vaihtaa
     *
     */
    public void setKey() {
        keyBeingSet = true;
        keytext = "";
        gui.writeKey(keytext);
    }

    /**
     * Metodi käsittelee syötetyn merkin ohjelman tilan vaatimalla tavalla.
     *
     * @param c
     */
    public void input(char c) {
        if (keyBeingSet) {
            plaintext = "";
            ciphertext = "";
            if (c != '\n') {
                keytext += c;
            } else {
                if (!cipher[activeCipher].setKey(keytext.toCharArray())) {
                    keytext = new String(cipher[activeCipher].getKey());
                }
                keyBeingSet = false;
                gui.keySet();
                gui.writeKey(keytext);
            }
        } else if (encryptMode) {
            plaintext += c;
            ciphertext += encrypt(c);
            gui.writeCipher(ciphertext);
        } else {
            plaintext += decrypt(c);
            ciphertext += c;
            gui.writePlain(plaintext);
        }
        if (c == '\n') {
            plaintext = "";
            ciphertext = "";
            gui.writePlain(plaintext);
            gui.writeCipher(ciphertext);
        }
    }
}
