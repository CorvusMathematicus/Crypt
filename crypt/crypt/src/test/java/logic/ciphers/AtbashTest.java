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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Kalle J. Ouwehand
 */
public class AtbashTest {

    private Atbash a;
    private char plain;
    private int key;
    private char result;

    @Before
    public void setUp() {
        a = new Atbash();
        plain = 'a';

    }

    @Test
    public void testGetKey() {
        assertArrayEquals(a.getKey(), "".toCharArray());
    }

    @Test
    public void testSetKey() {
        assertEquals(a.setKey("abc".toCharArray()), false);
    }

    @Test
    public void testEncrypt() {
        char input[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char output[] = new char[26];
        char expected[] = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        for (int i = 0; i < input.length; i++) {
            output[i] = a.encrypt(input[i]);
        }
        assertArrayEquals(output, expected);
    }
    
    @Test
    public void testDecrypt() {
        char input[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char output[] = new char[26];
        char expected[] = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        for (int i = 0; i < input.length; i++) {
            output[i] = a.decrypt(input[i]);
        }
        assertArrayEquals(output, expected);
    }
}
