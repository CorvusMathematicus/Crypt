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
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author korppi
 */
public class IOTest {

    private String input;
    private IO io;

    @Before
    public void setUp() {
    }

    @Test
    public void testInputString() {
        input = "Koe\n";
        io = new IO(new Scanner(input));
        String result = io.readLine();
        assertEquals(result, "Koe");
    }

    @Test
    public void testInputInt() {
        input = "36\n";
        io = new IO(new Scanner(input));
        int result = io.readInt();
        assertTrue(result == 36);
    }
}
