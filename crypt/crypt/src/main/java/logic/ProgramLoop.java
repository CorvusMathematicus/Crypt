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
 */
public class ProgramLoop {

    final private IO io;
    final private UI ui;
    final private Caesar caesar;
    private String input;

    public ProgramLoop(IO io, UI ui) {
        this.io = io;
        this.ui = ui;
        caesar = new Caesar();
    }

    public void mainLoop() {
        while (true) {
            ui.modeSelection();
            input = io.readLine();
            if (input.equals("l")) {
                break;
            } else if (input.equals("c")) {
                caesar();
            } else {
                ui.inputError();
            }
        }
        ui.finish();
    }

    private void caesar() {
        boolean validInput = false;
        while (true) {
            ui.caesar();
            ui.caesarInfo();
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
        ui.enterPlain();
        String plain = io.readLine();
        char c[] = caesar.encrypt(plain.toCharArray(), key);
        String cipher = new String();
        for (int i = 0; i < c.length; i++) {
            cipher+=c[i];
            System.out.println(c[i]);
        }
        ui.caesar();
        ui.showCipher(plain, cipher, key.toString());
    }
}
