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

import java.security.SecureRandom;
import logic.Logic;

/**
 *
 * @author Kalle J. Ouwehand
 *
 * Luokka toteuttaa OTP-salauksen (One-time pad)
 * @see logic.ciphers.Cipher
 */
public class OTP extends Cipher {

    private SecureRandom rnd = new SecureRandom();
    private int[] keyInts;
    private int keyPos;
    final private Caesar caesar;

    public OTP(Caesar c) {
        keyInts = new int[]{0};
        key = new char[]{' '};
        keyAvailable = new boolean[]{false, true};
        caesar = c;
    }

    @Override
    protected char encrypt(char plain) {
        if (plain == '\n') {
            keyPos = 0;
            return ' ';
        }
        prolongKey();
        char result = caesar.caesarShift(plain, keyInts[keyPos]);
        keyPos++;
        return result;
    }

    @Override
    protected char decrypt(char cipher) {
        if (cipher == '\n') {
            keyPos = 0;
            return ' ';
        }
        if (keyPos >= keyInts.length) {
            return ' ';
        }
        char result = caesar.caesarShift(cipher, -keyInts[keyPos]);
        keyPos++;
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

    //Menetelmä on kallis, mutta riittänee tähän hätään
    //Näin ei tarvitse muokata cipher-luokkaa, josta tämä periytetään enää enempää.
    private void prolongKey() {
        int newKeyInt = rnd.nextInt(alphabet.length);
        char newKey[];
        int newKeyInts[];
        if (keyPos == 0) {
            newKey = new char[]{intToChar(newKeyInt)};
            newKeyInts = new int[]{newKeyInt
            };
        } else {
            newKey = new char[key.length + 1];
            newKeyInts = new int[key.length + 1];
            for (int i = 0; i < key.length; i++) {
                newKeyInts[i] = keyInts[i];
                newKey[i] = key[i];
            }
            newKeyInts[key.length] = newKeyInt;
            newKey[key.length] = intToChar(newKeyInt);
        }
        keyInts = newKeyInts;
        key = newKey;
    }
}
