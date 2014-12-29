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
package ui;

/**
 *
 * @author Kalle J. Ouwehand
 *
 * Rajapinta sisältää käyttöliittymän metodit eri tilanteille Käyttöliittymä
 * toteuttaa tämän rajapinnan
 */
public interface UI {

    /**
     *
     * Valikko salauksen tai purkamisen valitsemiseksi
     */
    public void modeSelection();

    /**
     *
     * Valikko salausmenetelmän valitsemiseksi
     */
    public void cipherSelection();

    /**
     *
     * Caesar-salaus
     */
    public void caesar();

    /**
     *
     * Perustietoa Caesar-salauksesta, kuten avaimen muoto
     */
    public void caesarInfo();

    /**
     *
     * Playfair-salaus
     */
    public void playfair();

    /**
     *
     * Perustietoa playfair-salauksesta, kuten avaimen muoto
     */
    public void playfairInfo();

    /**
     *
     * Yleistietoa, kuten salausten hyväksymät merkit
     */
    public void generalInfo();

    /**
     *
     * Pyyntö kirjoittaa avain
     */
    public void enterKey();

    /**
     *
     * Pyyntö kirjoittaa salattu tai salaamaton viesti, riippuen
     * toimintamuodosta
     *
     * @param encrypt Jos encrypt on tosi, salataan, muutoin viestiä puretaan
     */
    public void enterText(boolean encrypt);

    /**
     *
     * Näytetään käyttäjälle salaamaton viesti, salattu viesti ja avain
     *
     * @param plain
     * @param cipher
     * @param key
     */
    public void showCipher(String plain, String cipher, String key);

    /**
     *
     * Kerrotaan käyttäjälle ohjelman suorituksen päättyvän
     */
    public void finish();

    /**
     *
     * Ilmoitetaan virheellisestä syötteestä
     */
    public void inputError();
}
