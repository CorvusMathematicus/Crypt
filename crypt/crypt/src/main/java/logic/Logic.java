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

import logic.ciphers.Cipher;

/**
 *
 * @author korppi
 *
 * Luokka sisältää varsinaisen ohjelmalogiikan.
 */
public class Logic {

    private boolean encryptMode;    //True=Salataan, False=Puretaan
    private int activeCipher;
    private Cipher cipher[];

    public Logic() {
        //Alustus
        activeCipher = 0;
        //cipher=new Cipher[]{};
    }

    /**
     * Metodilla asetetaan ohjelman tila.
     *
     * @param mode True=salaustila, False=purkutila
     */
    public void setEncryptMode(boolean mode) {
        encryptMode = mode;
    }

    /**
     * Metodi palauttaa onko ohjelma salaus- vai purkutilassa
     *
     * @return encryptMode
     */
    public boolean getEncryptMode() {
        return encryptMode;
    }

    public void setCipher(int cipherNumber) {
        activeCipher = cipherNumber;
    }
    
    public char[] encrypt(char c){
        return cipher[activeCipher].encrypt(c);
    }
    
    public char[] decrypt(char c){
        return cipher[activeCipher].decrypt(c);
    }
}
