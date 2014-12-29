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

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.TextUI;

/**
 *
 * @author korppi
 */
public class ProgramLoopTest {

    private ProgramLoop pL;
    private String input;

    @Before
    public void setUp() {
        pL = new ProgramLoop(new IO(new Scanner(input)), new TextUI());
    }

    //TODO: Toteuta testejä ja keksi mitä tässä testataan järkevästi, puolet luokasta on kutstuja käyttöliittymälle tai syötteenluvulle.
}
