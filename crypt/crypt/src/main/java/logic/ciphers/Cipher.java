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
 * Luokka toimii pohjana salauksille.
 */
abstract public class Cipher {

    private char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] key;

    /**
     *
     * Metodilla salataan yksi merkki
     *
     * @param plain     Salaamaton viesti
     * @return cipher   Salattu viesti
     */
    abstract public char[] encrypt(char plain);

    /**
     *
     * Metodilla puretaan yksi salattu merkki
     *
     * @param cipher    Salattu viesti
     * @return plain    Salaamaton viesti
     */
    abstract public char[] decrypt(char cipher);

    /**
     *
     * Metodilla asetetaan salaukselle avain
     *
     * @param key       Asetettava avain
     * @return success  Palauttaa toden, jos avaimen asettaminen onnistui, muuten palautetaan epätosi
     */
    abstract public boolean setKey(char key[]);

    /**
     *
     * Metodi palauttaa avaimen
     *
     * @return key  Avain
     */
    abstract public char[] getKey();
}
