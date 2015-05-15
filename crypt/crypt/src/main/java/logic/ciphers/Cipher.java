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
 * Luokka toimii pohjana salauksille. Salausten toiminta kuvataan tarkemmin
 * dokumentaatiokansion tiedostossa salaukset.md
 */
abstract public class Cipher {

    static protected char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    protected char[] key;
    protected boolean keyAvailable[] = {true, true}; //Voiko käyttäjä muuttaa avainkentän sisältöä salatessa ja purkaessa

    /**
     * Metodilla tarkistetaan merkin salattavuus. Jos merkki kuuluu
     * latinalaisiin aakkosiin, se ohjataan encrypt-metodille. Jos merkki ei
     * kuulu latinalaisiin aakkosiin, se palautetaan sellaisenaan. Huomaa:
     * Rivinvaihto ohjataan encrypt-metodille, jotta salaus osaa palautua
     * alkutilaan.
     *
     * @param plain
     * @return
     */
    public char preEncrypt(char plain) {
        if (this.charToInt(plain) != -1 || plain == '\n') {
            return encrypt(plain);
        } else {
            return plain;
        }
    }

    /**
     * Metodilla tarkistetaan merkin purettavuus. Jos merkki kuuluu
     * latinalaisiin aakkosiin, se ohjataan decrypt-metodille. Jos merkki ei
     * kuulu latinalaisiin aakkosiin, se palautetaan sellaisenaan. Huomaa:
     * Rivinvaihto ohjataan decrypt-metodille, jotta salaus osaa palautua
     * alkutilaan.
     *
     * @param plain
     * @return
     */
    public char preDecrypt(char plain) {
        if (this.charToInt(plain) != -1 || plain == '\n') {
            return decrypt(plain);
        } else {
            return plain;
        }
    }

    /**
     * Metodilla salataan yksi merkki. Metodia ei tule kutsua suoraan, vaan sen
     * sijaan kutsutaan preEncrypt-metodia.
     *
     * @param plain Salaamaton viesti
     * @return cipher Salattu viesti
     */
    abstract protected char encrypt(char plain);

    /**
     *
     * Metodilla puretaan yksi salattu merkki. Metodia ei tule kutsua suoraan,
     * vaan sen sijaan kutsutaan preDecrypt-metodia.
     *
     * @param cipher Salattu viesti
     * @return plain Salaamaton viesti
     */
    abstract protected char decrypt(char cipher);

    /**
     *
     * Metodilla asetetaan salaukselle avain
     *
     * @param key Asetettava avain
     * @return success Palauttaa toden, jos avaimen asettaminen onnistui, muuten
     * palautetaan epätosi
     */
    abstract public boolean setKey(char key[]);

    /**
     *
     * Metodi palauttaa avaimen
     *
     * @return key Avain
     */
    abstract public char[] getKey();

    /**
     *
     * Metodi muuttaa merkin luvuksi salausalgoritmeja varten. Luku on merkin
     * järjestysluku siten, että a=0. Huomaa: Jos merkki ei ole latinalaisten
     * aakkosten kirjain, palautetaan -1.
     *
     * @param c Merkki
     * @return i Merkkiä vastaava luku, -1 jos merkki ei ole latinalaisten
     * aakkosten kirjain.
     */
    protected int charToInt(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (c == alphabet[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metodi palauttaa lukua vastaavan latinalaisten aakkosten merkin. Huomaa:
     * Metodi palauttaa aina merkin. Tämä on tarkoituksellista, sillä useissa
     * tilanteissa salaus voi tuottaa liian ison tai liian pienen lukuarvon
     * merkille. Tämä metodi korjaa ongelman automaattisesti.
     *
     * @param i Merkiksi muutettava luku
     * @return c Lukua vastaava merkki
     */
    protected char intToChar(int i) {
        while (i >= 26) {
            i -= 26;
        }
        while (i < 0) {
            i += 26;
        }
        return alphabet[i];
    }

    /**
     * Palauttaa tiedon siitä, milloin käyttäjä voi muuttaa avainta. Eli siis,
     * milloin avain on käyttäjän asettama ja milloin tietokoneen, tai sitä ei
     * ole.
     *
     * @return keyAvailable Voiko avainta muuttaa salatessa ja purkaessa, tässä
     * järjestyksessä
     */
    public boolean[] getKeyAvailability() {
        return keyAvailable;
    }
}
