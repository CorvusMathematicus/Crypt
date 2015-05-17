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
package logic.ciphers;

/**
 *
 * @author Kalle J. Ouwehand
 *
 * Luokka toteuttaa Autokey-salauksen
 * @see logic.ciphers.Cipher
 */
public class Autokey extends Cipher {

    private int[] keyInts;
    private int keyPos;
    final private Caesar caesar;

    public Autokey(Caesar c) {
        keyInts = new int[]{11, 5, 25};
        key = "key".toCharArray();
        caesar = c;
    }

    @Override
    protected char encrypt(char plain) {
        if (plain == '\n') {
            setKey(key);    //Näin saadaan käyttöön alkuperäisen avaimen luvut, eikä jonkin viestin kohdan luvut.
            return ' ';
        }
        char result = caesar.caesarShift(plain, keyInts[0]);
        keyInts = updateKeyInts(keyInts, plain);
        return result;
    }

    @Override
    protected char decrypt(char cipher) {
        if (cipher == '\n') {
            this.setKey(key);    //Näin saadaan käyttöön alkuperäisen avaimen luvut, eikä jonkin viestin kohdan luvut.
            return ' ';
        }
        char result = caesar.caesarShift(cipher, -keyInts[0]);
        keyInts = updateKeyInts(keyInts, result);
        return result;
    }

    @Override
    public boolean setKey(char c[]) {
        int newKeyInts[] = new int[c.length];
        int j;
        for (int i = 0; i < c.length; i++) {
            j = this.charToInt(c[i]);
            if (j == -1) {
                return false;
            } else {
                newKeyInts[i] = j + 1;
            }
        }
        key = c;
        keyInts = newKeyInts;
        return true;
    }

    @Override
    public char[] getKey() {
        return key;
    }

    private int[] updateKeyInts(int kI[], char lastInput) {
        for (int i = 0; i < kI.length - 1; i++) {
            kI[i] = kI[i + 1];
        }
        kI[kI.length - 1] = this.charToInt(lastInput) + 1;
        return kI;
    }
}
