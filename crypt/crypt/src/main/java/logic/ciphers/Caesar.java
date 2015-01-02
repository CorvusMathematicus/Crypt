/*
 * Copyright (C) 2014 korppi
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
package logic.ciphers;

import misc.AlphabetArray;

/**
 *
 * @author Kalle J. Ouwehand
 *
 * Luokka toteuttaa Caesar-salauksen
 */
public class Caesar implements AlphabetArray {

    /**
     *
     * Metodi toteuttaa salauksen
     *
     * @param plain Salaamaton viesti
     * @param key Salausavain (luku välillä 0-25)
     * @return cipher Salattu viesti
     */
    public char[] encrypt(char plain[], int key) {
        char cipher[] = plain;
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (cipher[i] == ALPHABET[j]) {
                    cipher[i] = ALPHABET[caesarShift(j, key)];
                    break;
                }
            }
        }
        return cipher;
    }

    /**
     *
     * Metodi toteuttaa salauksen purkamisen
     *
     * @param cipher Salattu viesti
     * @param key Salausavain
     * @return plain Salaamaton viesti
     */
    public char[] decrypt(char cipher[], int key) {
        return encrypt(cipher, -key);    //Caesar-salaus puretaan vähentämällä avain lisäämisen sijaan.
    }

    //Palauttaa käsitellyn merkin
    private int caesarShift(int value, int key) {
        int i = value + key;
        while (i >= ALPHABET.length) {
            i -= ALPHABET.length;
        }
        while (i < 0) {
            i += ALPHABET.length;
        }
        return i;
    }
}
