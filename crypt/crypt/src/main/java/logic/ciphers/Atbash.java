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
 * Luokka toteuttaa Atbash-salauksen
 * @see logic.ciphers.Cipher
 */
public class Atbash extends Cipher {

    public Atbash() {
        keyAvailable = new boolean[]{false, false};
    }

    @Override
    protected char encrypt(char plain) {
        int i = this.charToInt(plain);
        char result = this.intToChar(25 - i);
        return result;
    }

    @Override
    /**
     * Atbash-salauksen purkaminen ja salaaminen ovat sama operaatio.
     */
    protected char decrypt(char cipher) {
        return encrypt(cipher);
    }

    /**
     * Atbash-salaus ei käytä avainta, tämä metodi ei tee mitään.
     *
     * @param c
     * @return false Avainta ei asetettu
     */
    @Override
    public boolean setKey(char c[]) {
        return false;
    }

    /**
     * Palauttaa tyhjän avaimen. (avainta ei ole)
     *
     * @return
     */
    @Override
    public char[] getKey() {
        return "".toCharArray();
    }
}
