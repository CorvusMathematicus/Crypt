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
package logic;

import logic.ciphers.*;
import ui.*;

/**
 *
 * @author Kalle J. Ouwehand
 *
 * Luokka toimii ohjelman runkona Luokka luo ohjelman tarvitsemat oliot ja
 * kutsuu niiden tarvitsemia metodeja
 */
public class ProgramLoop {

    final private IO io;
    final private UI ui;
    final private Caesar caesar;
    private String input;

    /**
     * @param io Käyttäjän syötettä lukeva luokka
     * @param ui Käyttöliittymä
     */
    public ProgramLoop(IO io, UI ui) {
        this.io = io;
        this.ui = ui;
        caesar = new Caesar();
    }

    /**
     * Ohjelman eri vaiheiden suoritus tapahtuu tässä silmukassa
     */
    public void mainLoop() {
        while (true) {
            boolean mode;
            ui.modeSelection();
            input = io.readLine();
            if (input.equals("l")) {
                break;
            } else if (input.equals("s")) {
                mode = true;
                cipherSelect(mode);
            } else if (input.equals("p")) {
                mode = false;
                cipherSelect(mode);
            } else {
                ui.inputError();
            }
        }
        ui.finish();
    }

    private void cipherSelect(boolean mode) {
        while (true) {
            ui.cipherSelection();
            input = io.readLine();
            if (input.equals("c")) {
                caesar(mode);
                break;
            } else {
                ui.inputError();
            }
        }
    }

    private void caesar(boolean mode) {
        //TODO: Siisti.
        boolean validInput = false;
        while (true) {
            ui.caesar();
            ui.caesarInfo();
            ui.generalInfo();
            ui.enterKey();
            input = io.readLine();
            if (input.matches("([01]?[0-9])|(2[0-5])")) {
                break;
            } else {
                ui.inputError();
            }
        }
        Integer key = Integer.parseInt(input);
        ui.caesar();
        ui.enterText(mode);
        String plain = io.readLine();
        char c[];
        if (mode) {
            c = caesar.encrypt(plain.toCharArray(), key);
        } else {
            c = caesar.encrypt(plain.toCharArray(), -key);
        }
        String cipher = new String();
        for (int i = 0; i < c.length; i++) {
            cipher += c[i];
        }
        ui.caesar();
        if (mode) {
            ui.showCipher(plain, cipher, key.toString());
        } else {
            ui.showCipher(cipher, plain, key.toString());
        }
    }
}
