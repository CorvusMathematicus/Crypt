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
 * Luokka toteuttaa OTP-salauksen (One-time pad)
 * @see logic.ciphers.Cipher
 */
public class OTP extends Cipher {

    private int[] keyInts;
    private int keyPos;
    final private Caesar caesar;

    public OTP(Caesar c) {
        keyInts = new int[]{0};
        key = new char[]{' '};
        caesar = c;
    }

    @Override
    protected char encrypt(char plain) {
        if (plain == '\n') {
            keyPos = 0;
            return ' ';
        }
        char result = caesar.caesarShift(plain, keyInts[keyPos]);
        keyPos++;
        if (keyPos >= keyInts.length) {
            return ' ';
        }
        return result;
    }

    @Override
    protected char decrypt(char cipher) {
        if (cipher == '\n') {
            keyPos = 0;
            return ' ';
        }
        char result = caesar.caesarShift(cipher, -keyInts[keyPos]);
        keyPos++;
        if (keyPos >= keyInts.length) {
            return ' ';
        }
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
        keyPos = 0;
        return true;
    }

    @Override
    public char[] getKey() {
        return key;
    }
}