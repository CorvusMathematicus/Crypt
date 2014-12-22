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
 */
public class Caesar implements AlphabetArray {

    public char[] encrypt(char plain[], int key) {
        char cipher[] = plain;
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (cipher[i] == alphabet[j]) {
                    cipher[i] = alphabet[caesarShift(j, key)];
                    break;
                }
            }
        }
        return cipher;
    }

    public char[] decrypt(char cipher[], int key) {
        return encrypt(cipher, -key);    //Caesar-salaus puretaan vähentämällä avain lisäämisen sijaan.
    }

    //Palauttaa käsitellyn merkin
    private int caesarShift(int value, int key) {
        int i = value + key;
        while (i >= alphabet.length) {
            i -= alphabet.length;
        }
        while (i < 0) {
            i += alphabet.length;
        }
        return i;
    }
}