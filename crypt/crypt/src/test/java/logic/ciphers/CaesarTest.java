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
 * @author korppi
 */
public class CaesarTest {

    private Caesar c = new Caesar();
    private char[] plain;
    private int key;
    private char[] result;

    @Before
    public void setUp() {
        c = new Caesar();
        plain = new char[]{'a', 'b', 'c'};
        key = 25;
    }

    @Test
    public void testEncryptNoKey() {
        key = 0;
        result = c.encrypt(plain, key);
        assertArrayEquals(result, plain);
    }

    @Test
    public void testEncryptMaxKey() {
        plain = new char[]{'a', 'a', 'a'};
        result = c.encrypt(plain, key);
        assertArrayEquals(result, new char[]{'z', 'z', 'z'});
    }

    @Test
    public void testEncryptLoop() {
        result = c.encrypt(plain, key);
        assertArrayEquals(result, new char[]{'z', 'a', 'b'});
    }

    @Test
    //Tämä on mitä purkaminen itse asiassa tekee
    public void testEncryptNegativeKey() {
        key = -1;
        result = c.encrypt(plain, key);
        assertArrayEquals(result, new char[]{'z', 'a', 'b'});
    }

    @Test
    public void testDecrypt() {
        plain = new char[]{'z', 'a', 'b'};
        result = c.decrypt(plain, key);
        assertArrayEquals(result, new char[]{'a', 'b', 'c'});
    }
}
