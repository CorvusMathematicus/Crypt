/*
 * Copyright (C) 2015 Kalle J. Ouwehand
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
 * Tämä luokka testaa Cipher-luokan metodeja. Sillä Cipher-luokka on abstrakti,
 * testataan sen metodeja siitä periytetyn Caesar-luokan avulla.
 *
 * @author Kalle J. Ouwehand
 */
public class CipherTest {

    private Caesar c;
    private char plain;
    private char result;
    private char cipher;
    private char[] key;

    @Before
    public void setUp() {
        c = new Caesar();
        plain = 'a';
        cipher = 'b';
        key = new char[]{'1'};
        c.setKey(key);
    }

    @Test
    public void testIntToChar() {
        boolean working = true;
        for (int i = 0; i < c.alphabet.length; i++) {
            if (c.intToChar(i) != c.alphabet[i]) {
                working = false;
                break;
            }
        }
        assertEquals(working, true);
    }

    @Test
    public void testIntToCharHighValue() {
        assertEquals(c.intToChar(26), 'a');
    }

    @Test
    public void testIntToCharNegativeValue() {
        assertEquals(c.intToChar(-1), 'z');
    }

    @Test
    public void testCharToInt() {
        boolean working = true;
        for (int i = 0; i < c.alphabet.length; i++) {
            if (c.charToInt(c.alphabet[i]) != i) {
                working = false;
                break;
            }
        }
        assertEquals(working, true);
    }

    @Test
    public void testCharToIntInvalidChar() {
        assertEquals(c.charToInt(' '), -1);
    }

    @Test
    public void testPreEncryptValid() {
        assertEquals(c.preEncrypt(plain), cipher); //Katsotaan, että viesti salataan oikein. En keksi paremaakaan.
    }
    
    @Test
    public void testPreEncryptInvalid() {
        assertEquals(c.preEncrypt(' '), ' ');
    }
    
    @Test
    public void testPreEncryptEnter() {
        assertEquals((c.preEncrypt('\n')=='\n'), false);
    }

    @Test
    public void testPreDecryptValid() {
        assertEquals(c.preDecrypt(cipher), plain); //Katsotaan, että viesti puretaan oikein. En keksi paremaakaan.
    }
    
    @Test
    public void testPreDecryptInvalid() {
        assertEquals(c.preDecrypt(' '), ' ');
    }
    
    @Test
    public void testPreDecryptEnter() {
        assertEquals((c.preDecrypt('\n')=='\n'), false);
    }
}
