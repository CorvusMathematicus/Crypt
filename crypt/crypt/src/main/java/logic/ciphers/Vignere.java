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
 * @author korppi
 *
 * Luokka toteuttaa Vignere-salauksen
 * @see logic.ciphers.Cipher
 */
public class Vignere extends Cipher {

    private int[] keyInts;
    private int keyPos;
    final private Caesar caesar;

    public Vignere(Caesar c) {
        keyInts = new int[]{0};
        key = new char[]{' '};
        caesar = c;
    }

    @Override
    public char encrypt(char plain) {
        char result = caesar.caesarShift(plain, keyInts[keyPos]);
        keyPos++;
        if (keyPos >= keyInts.length) {
            keyPos = 0;
        }
        return result;
    }

    @Override
    public char decrypt(char cipher) {
        char result = caesar.caesarShift(cipher, -keyInts[keyPos]);
        keyPos++;
        if (keyPos >= keyInts.length) {
            keyPos = 0;
        }
        return result;
    }

    @Override
    public boolean setKey(char c[]) {
        int newKeyInts[] = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            boolean validChar = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (c[i] == alphabet[j]) {
                    validChar = true;
                    newKeyInts[i] = j + 1;
                    break;
                }
            }
            if (!validChar) {
                return false;
            }
        }
        key = c;
        keyInts = newKeyInts;
        keyPos = 0;
        return true;
    }

    @Override
    public char[] getKey() {
        return key;
    }
}
