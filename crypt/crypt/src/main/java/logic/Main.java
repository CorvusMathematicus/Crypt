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

import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import ui.*;

/**
 *
 * @author Kalle J. Ouwehand
 */
public class Main {

    public static void main(String args[]) {

        //Graafinen käyttöliittymä itsessään toimii, mutta salauksia ei ole vielä liitetty siihen.
        SwingUtilities.invokeLater(new GUI());

        Scanner s = new Scanner(System.in);
        IO io = new IO(s);
        UI ui = new TextUI();
        ProgramLoop loop = new ProgramLoop(io, ui);
        loop.mainLoop();
    }
}
