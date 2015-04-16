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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kalle J. Ouwehand
 */
public class CaesarTest {

    private Caesar c;
    private char plain;
    private int key;
    private char result;

    @Before
    public void setUp() {
        c = new Caesar();
        plain = 'a';
        key = 25;
        c.setKey("25".toCharArray());
    }

    @Test
    public void testGetKey() {
        assertArrayEquals(c.getKey(), "25".toCharArray());
    }

    @Test
    public void testSetKey() {
        c.setKey("0".toCharArray());
        assertArrayEquals(c.getKey(), "0".toCharArray());
    }

    @Test
    public void testInvalidKey1() {
        c.setKey("q".toCharArray());
        assertArrayEquals(c.getKey(), "25".toCharArray());
    }

    @Test
    public void testInvalidKey2() {
        c.setKey("26".toCharArray());
        assertArrayEquals(c.getKey(), "25".toCharArray());
    }

    @Test
    public void testEncryptNoKey() {
        c.setKey("0".toCharArray());
        result = c.encrypt(plain);
        assertEquals(result, plain);
    }

    @Test
    public void testEncryptMaxKey() {
        result = c.encrypt(plain);
        assertEquals(result, 'z');
    }

    @Test
    public void testEncryptLoop() {
        plain = 'b';
        result = c.encrypt(plain);
        assertEquals(result, 'a');
    }

    @Test
    public void testDecryptLoop() {
        result = c.decrypt(plain);
        assertEquals(result, 'b');
    }

    @Test
    public void caesarShiftLoop() {
        result = c.caesarShift('z', 1);
        assertEquals(result, 'a');
    }

    @Test
    public void caesarShiftNegativeKeyLoop() {
        result = c.caesarShift('a', -1);
        assertEquals(result, 'z');
    }
}
