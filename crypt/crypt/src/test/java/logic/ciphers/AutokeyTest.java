/*
 * Copyright (C) 2015 korppi
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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Kalle J. Ouwehand
 */
public class AutokeyTest {

    private Autokey a;
    private char[] plain;
    private char[] result;
    private char[] cipher;
    private char[] key;

    @Before
    public void setUp() {
        a = new Autokey(new Caesar());
        plain = new char[]{'z', 'b', 'c', 'd'};
        cipher = new char[]{'a', 'b', 'c', 'f'};
        key = new char[]{'a', 'z'};
        result = new char[4];
        a.setKey(key);
    }

    @Test
    public void testGetKey() {
        assertArrayEquals(a.getKey(), key);
    }

    @Test
    public void testSetKey() {
        char[] c = {'a', 'b'};
        a.setKey(c);
        assertArrayEquals(a.getKey(), c);
    }

    @Test
    public void testInvalidKey() {
        a.setKey("25".toCharArray());
        assertArrayEquals(a.getKey(), key);
    }

    @Test
    public void testEncryptLoop() {
        result[0] = a.encrypt(plain[0]);
        assertEquals(result[0], cipher[0]);
    }

    @Test
    public void testDecryptLoop() {
        result[0] = a.decrypt(cipher[0]);
        assertEquals(result[0], plain[0]);
    }

    @Test
    public void testEncryptTextKey() {
        result = new char[plain.length];
        for (int i = 0; i < plain.length; i++) {
            result[i] = a.encrypt(plain[i]);
        }
        assertArrayEquals(result, cipher);
    }

    @Test
    public void testDecryptTextKey() {
        result = new char[cipher.length];
        for (int i = 0; i < cipher.length; i++) {
            result[i] = a.decrypt(cipher[i]);
        }
        assertArrayEquals(result, plain);
    }

    @Test
    public void testKeyResetOnNewline() {
        char c = a.encrypt('a');
        a.encrypt('\n');
        c = a.encrypt('a');
        assertEquals(c, 'b');
    }
}