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
 */
public class TextUI implements UI {

    private void print(String s) {
        System.out.print(s);
    }

    @Override
    public void modeSelection() {
        this.print("Kommenot:\n"
                + "  Caesar-salaus (c)\n"
                + "  Lopetus (l)\n\n"
                + "Valitse toiminto: ");
    }

    @Override
    public void caesar() {
        this.print("Caesar-salaus:\n");
    }

    @Override
    public void caesarInfo() {
        this.print("  Caesar-salauksen avain on luku välillä 0-25"
                + "  (0 on salaamaton, joten sitä ei suositella käytettäväksi)\n"
                + "  Caesar-salaus kelpuuttaa vain pieniä kirjaimia ilman ääkkösiä,\n"
                + "  ei mitään muuta, ei edes välilyöntejä.\n");
    }

    @Override
    public void enterKey() {
        this.print("Anna avain: ");
    }

    @Override
    public void enterPlain() {
        this.print("Syötä salattava teksti: ");
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
