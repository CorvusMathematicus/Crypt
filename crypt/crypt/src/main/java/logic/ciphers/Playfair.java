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

import static misc.AlphabetArray.alphabet;

/**
 *
 * @author korppi
 *
 * Luokka on keskeneräinen eikä käytettävissä Luokka toteuttaa
 * Playfair-salauksen ja sen purkamisen
 */
public class Playfair {

    /**
     *
     * @param plain Salaamaton teksti
     * @param key Salausavain 5x5-taulukko, joka sisältää aakkoset välillä a-z
     * j:tä lukuunottamatta j tulkitaan i:ksi aakkosten mahduttamiseksi 25
     * merkkiin
     * @return
     */
    public char[] encrypt(char plain[], char key[][]) {
        char modifiedPlain[] = jToI(plain);
        //Johtuen tietyistä playfair-salauksen ominaisuuksista, salattu muoto voi olla pidempi kuin alkuperäinen
        char cipher[] = new char[plain.length]; //TODO: Kehitä jotain pituuden kanssa

        /*
         //Käytetään while-rakennetta, sillä i voi muuttua useita kertoja iteraation aikana.
         int i = 0;
         while (i < modifiedPlain.length) {
         char c[] = new char[2];
         for (int pairMember = 0; pairMember < 2; pairMember++) {
         while (true) {
         c[pairMember] = plain[i];
         if (cipherable(c[pairMember])) {
         break;
         } else {
         if (i < modifiedPlain.length - 1) {
         i++;
         } else {
         if (pairMember == 1) {
         //Lisää tarvittaessa loppuun q
         c[pairMember] = 'q';
         }
         break;
         }
         }
         }
         i++;
         }
         c = playfairAlter(c, key);
         for (int pairMember = 0; pairMember < 2; pairMember++) {
         cipher[i + pairMember] = c[pairMember];
         }
         }*/
        return cipher;
    }
    //Avain on 5*5-taulukko, joka sisältää aakkoset välillä a-z j:tä lukuunottamatta
    //j tulkitaan i:ksi

    /**
     *
     * @param cipher
     * @param key
     * @return
     */
    public char[] decrypt(char cipher[], char key[][]) {
        //NYI
        return null;
    }

    private char[] jToI(char plain[]) {
        for (int i = 0; i < plain.length; i++) {
            if (plain[i] == 'j') {
                plain[i] = 'i';
            }
        }
        return plain;
    }

    //Käytetään kirjainparin salaamiseen
    private char[] playfairAlter(char plainPair[], char key[][]) {
        char cipherPair[] = plainPair;
        int keyPos[][] = new int[2][2];   //Kirjain (0/1); avaimen X- ja Y- arvot
        for (int pairMember = 0; pairMember < 2; pairMember++) {
            for (int x = 0; x < key.length; x++) {
                for (int y = 0; y < key[x].length; y++) {
                    if (key[x][y] == cipherPair[pairMember]) {
                        keyPos[pairMember][0] = x;
                        keyPos[pairMember][1] = y;
                    }
                }
            }
        }
        //Käydään Playfair-salauksen säännöt läpi
        //Merkit eivät voi olla samoja, se tarkistetaan paria muodostaessa
        //Merkit ovat samalla rivillä
        /*if (keyPos[0][0] == keyPos[1][0]) {
         for (int i = 0; i < 2; i++) {
         }
         }*/
        return cipherPair;
    }

    private boolean cipherable(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (c == alphabet[i]) {
                return true;
            }
        }
        return false;
    }
}
