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
 * Luokka sisältää toistaiseksi käytössä olevan tekstikäyttöliittymän Metodit
 * tulostavat tietyn tekstin
 *
 * Metodien kuvaukset:
 * @see ui.UI
 */
public class TextUI implements UI {

    private void print(String s) {
        System.out.print(s);
    }

    @Override
    public void modeSelection() {
        this.print("Valitse toimintamuoto:\n"
                + "  Salaus (s)\n"
                + "  Salauksen purku (p)\n"
                + "  Lopetus (l)\n\n"
                + "Valitse toiminto: ");
    }

    @Override
    public void cipherSelection() {
        this.print("Valitse salaus:\n"
                + "  Caesar-salaus (c)\n\n"
                + "Valitse toiminto: ");
    }

    @Override
    public void caesar() {
        this.print("Caesar-salaus:\n");
    }

    @Override
    public void caesarInfo() {
        this.print("  Caesar-salauksen avain on luku välillä 0-25"
                + "  (0 on salaamaton, joten sitä ei suositella käytettäväksi)\n");
    }

    @Override
    public void playfair() {
        this.print("Playfair-salaus:\n");
    }

    @Override
    public void playfairInfo() {
        this.print("  Playfair-salauksen avain on aakkoset sisältävä 5*5 taulukko.\n");
        this.print("  Sillä taulukko voi sisältää vain 25 kirjainta playfair tulkitsee j:n i:ksi.\n");
        this.print("  Playfair-salaus salaa kirjainpareja,\n");
        this.print("  joten tekstin loppuun lisätään satunnainen kirjain, mikäli sen pituus on pariton\n");
    }

    @Override
    public void generalInfo() {
        this.print("  Salaukset salaavat vain pieniä kirjaimia ilman ääkkösiä.\n"
                + "  Muut merkit päätyvät salattuun viestiin muuttumattomina.\n");
    }

    @Override
    public void enterKey() {
        this.print("Anna avain: ");
    }

    @Override
    public void enterText(boolean encrypt) {
        if (encrypt) {
            this.enterPlain();
        } else {
            this.enterCipher();
        }
    }

    private void enterPlain() {
        this.print("Syötä salattava teksti: ");
    }

    private void enterCipher() {
        this.print("Syötä purettava teksti: ");
    }

    @Override
    public void showCipher(String plain, String cipher, String key) {
        this.print("Avain:             " + key + "\n"
                + "Salaamaton teksti: " + plain + "\n"
                + "Salattu teksti:    " + cipher + "\n\n");
    }

    @Override
    public void finish() {
        this.print("Ohjelman suoritus päättyy.\n");
    }

    @Override
    public void inputError() {
        this.print("Virheellinen syöte.\n");
    }

}
