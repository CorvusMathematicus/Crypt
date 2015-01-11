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

/**
 *
 * @author Kalle J. Ouwehand
 *
 * Luokka toteuttaa Caesar-salauksen
 * @see logic.ciphers.Cipher
 */
public class Caesar extends Cipher {

    private int keyInt;

    public Caesar() {
        keyInt = 0;
        key = new char[]{'0'};
    }

    @Override
    public char encrypt(char plain) {
        return caesarShift(plain, keyInt);
    }

    @Override
    public char decrypt(char cipher) {
        return caesarShift(cipher, -keyInt);
    }

    @Override
    public boolean setKey(char c[]) {
        int i;
        try {
            i = Integer.parseInt(new String(c));
        } catch (Exception e) {
            return false;
        }
        if (i >= 0 && i < 26) {
            keyInt = i;
            key = c;
            return true;
        }
        return false;
    }

    @Override
    public char[] getKey() {
        return key;
    }

    /**
     * Metodi suorittaa caesar-salauksen annetulle merkille annetulla avaimella.
     * Metodi on julkinen, sillä myös Vignere-salaus käyttää sitä.
     * Huomaa: Caesar- ja Vignere-salausten purkaminen toteutetaan kutsumalla metodia avaimen vastaluvulla (-key).
     *
     * @param c         Salattava merkki
     * @param k         Avainluku
     * @return cipher   Salattu merkki
     */
    public char caesarShift(char c, int k) {
        char result = c;
        for (int i = 0; i < alphabet.length; i++) {
            if (result == alphabet[i]) {
                int value = i + k;
                while (value >= alphabet.length) {
                    value -= alphabet.length;
                }
                while (value < 0) {
                    value += alphabet.length;
                }
                result = alphabet[value];
                break;
            }
        }
        return result;
    }
}
