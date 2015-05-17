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
public class OTPTest {

    private OTP o;
    private char[] plain;
    private char[] result;
    private char[] cipher;
    private char[] key;

    @Before
    public void setUp() {
        o = new OTP(new Caesar());
        plain = new char[]{'z', 'b'};
        cipher = new char[]{'a', 'b', 'c'};
        key = new char[]{'a', 'z'};
        result = new char[4];
        o.setKey(key);
    }

    @Test
    public void testGetKey() {
        assertArrayEquals(o.getKey(), key);
    }

    @Test
    public void testSetKey() {
        char[] c = {'a', 'b'};
        o.setKey(c);
        assertArrayEquals(o.getKey(), c);
    }

    @Test
    public void testInvalidKey() {
        o.setKey("25".toCharArray());
        assertArrayEquals(o.getKey(), key);
    }

    @Test
    public void testDecryptLoop() {
        result[0] = o.decrypt(cipher[0]);
        assertEquals(result[0], plain[0]);
    }

    @Test
    public void testDecryptKeyFinished() {
        for (int i = 0; i <= o.key.length; i++) {
            result[i] = o.decrypt(cipher[i]);
        }
        assertEquals(result[2], ' ');
    }

    @Test
    public void testKeyResetOnNewline() {
        o.setKey(new char[]{'a', 'b', 'c'});
        o.decrypt('a');
        o.decrypt('\n');
        char c = o.decrypt('a');
        assertEquals(c, 'z');
    }
}
