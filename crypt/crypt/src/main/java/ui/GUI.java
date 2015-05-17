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
package ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.*;
import static javax.swing.WindowConstants.*;
import logic.Logic;

/**
 *
 * @author Kalle J. Ouwehand
 *
 * Luokka sisältää graafisen käyttöliittymän.
 */
public class GUI implements Runnable, ActionListener {

    private JFrame frame;
    //private boolean encryptMode;
    private JTextField plaintext;
    private JTextField ciphertext;
    private JTextField keytext;
    final private JButton setKeyButton = new JButton("Set key");
    final private KeyListener kl;
    final private Logic logic;
    private static Font font;

    String plain;
    String cipher;
    String key;

    public GUI() {
        logic = new Logic(this);
        kl = new KeyInput(logic);
        plain = new String();
        cipher = new String();
        key = new String();
        font = new Font("monospaced", Font.PLAIN, 16);
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Crypt");
        JPanel panel = new JPanel();
        createComponents(panel);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Reagoidaan käyttöliitymän napin painallukseen. Tapahtumasta (painetusta
     * napista) riippuen säädetään salaustilaa, salausmenetelmää tai avainta.
     *
     * @param a Metodin laukaissut tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent a) {
        String action = a.getActionCommand();
        if (action.equals("encrypt")) {
            logic.setEncryptMode(true);
            plaintext.setEnabled(true);
            ciphertext.setEnabled(false);
        } else if (action.equals("decrypt")) {
            logic.setEncryptMode(false);
            plaintext.setEnabled(false);
            ciphertext.setEnabled(true);
        } else if (action.equals("atbash")) {
            logic.setCipher(0);
        } else if (action.equals("caesar")) {
            logic.setCipher(1);
        } else if (action.equals("vigenere")) {
            logic.setCipher(2);
        } else if (action.equals("autokey")) {
            logic.setCipher(3);
        } else if (action.equals("OTP")) {
            logic.setCipher(4);
        } else if (action.equals("setKey")) {
            logic.setKey();
            plaintext.setEnabled(false);
            ciphertext.setEnabled(false);
            keytext.setEnabled(true);
        }
    }

    /**
     * Kutsutaan kun avain on asetettu ja halutaan palata normaalitilaan.
     */
    public void keySet() {
        plaintext.setEnabled(logic.getEncryptMode());
        ciphertext.setEnabled(!logic.getEncryptMode());
        keytext.setEnabled(false);
    }

    /**
     * Palauttaa ruudun
     *
     * @return frame luokan luoma ja käyttämä ruutu
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Kirjoittaa salaamattoman tekstin näkyviin.
     *
     * @param s Salaamaton teksti
     */
    public void writePlain(String s) {
        plaintext.setText(s);
    }

    /**
     * Kirjoittaa salatun tekstin näkyviin.
     *
     * @param s Salattu teksti
     */
    public void writeCipher(String s) {
        ciphertext.setText(s);
    }

    /**
     * Kirjoittaa avaimen näkyviin.
     *
     * @param s Salaamaton merkki
     */
    public void writeKey(String s) {
        keytext.setText(s);
    }

    /**
     * Metodi sallii avaimen asettamisen. Tätä kutsutaan, kun salaus tarvitsee
     * avaimen.
     */
    public void enableKey() {
        setKeyButton.setEnabled(true);
    }

    /**
     * Metodi estää avaimen asettamisen. Tätä kutsutaan käytettäessä salausta,
     * jossa ei ole avainta, tai käyttäjä ei aseta sitä.
     */
    public void disableKey() {
        setKeyButton.setEnabled(false);
    }

    private void createComponents(Container container) {
        BoxLayout layout;
        layout = new BoxLayout(container, BoxLayout.X_AXIS);

        JPanel settingsPanel = new JPanel();
        initSettingsPanel(settingsPanel);
        container.add(settingsPanel);

        JPanel textPanel = new JPanel();
        initTextPanel(textPanel);
        container.add(textPanel);

        JPanel keyPanel = new JPanel();
        initKeyPanel(keyPanel);
        container.add(keyPanel);

        container.setLayout(layout);
    }

    private void initSettingsPanel(JPanel panel) {
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel encryptionMode = new JPanel();
        initEncryptionMode(encryptionMode);
        panel.add(encryptionMode);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel cipherMode = new JPanel();
        initCipherMode(cipherMode);
        panel.add(cipherMode);
        panel.add(Box.createGlue());
    }

    private void initTextPanel(JPanel panel) {
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel plainHeadline = new JLabel("Plaintext:");
        panel.add(plainHeadline);
        plaintext = new JFormattedTextField();
        plaintext.addKeyListener(kl);
        plaintext.setFont(font);
        plaintext.setEnabled(true);
        logic.setEncryptMode(true);
        panel.add(plaintext);
        JLabel cipherHeadline = new JLabel("Ciphertext:");
        panel.add(cipherHeadline);
        ciphertext = new JFormattedTextField();
        ciphertext.addKeyListener(kl);
        ciphertext.setFont(font);
        ciphertext.setEnabled(false);
        panel.add(ciphertext);
        panel.add(Box.createGlue());
    }

    private void initKeyPanel(JPanel panel) {
        panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);  //TOP_ALIGNMENT kuulostaa järkevämmältä, jos katsotaan miltä käyttöliittymän pitäisi näyttää, mutta tulos on silloin päinvastainen.
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel headLine = new JLabel("Key:");
        panel.add(headLine);
        keytext = new JTextField("3");
        keytext.setEnabled(false);
        keytext.setFont(font);
        keytext.addKeyListener(kl);
        setKeyButton.setActionCommand("setKey");
        setKeyButton.addActionListener(this);
        panel.add(keytext);
        panel.add(setKeyButton);
        panel.add(Box.createGlue());
    }

    private void initEncryptionMode(JPanel panel) {
        ButtonGroup encryptionButtons = new ButtonGroup();
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel headline = new JLabel("Encryption mode:");
        JRadioButton encryptButton = new JRadioButton("Encrypt");
        encryptButton.setSelected(true);
        encryptButton.setActionCommand("encrypt");
        encryptButton.addActionListener(this);
        encryptionButtons.add(encryptButton);
        JRadioButton decryptButton = new JRadioButton("Decrypt");
        decryptButton.setActionCommand("decrypt");
        decryptButton.addActionListener(this);
        encryptionButtons.add(decryptButton);
        panel.add(headline);
        panel.add(encryptButton);
        panel.add(decryptButton);
    }

    private void initCipherMode(JPanel panel) {
        ButtonGroup cipherButtons = new ButtonGroup();
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel headline = new JLabel("Cipher:");
        panel.add(headline);
        JRadioButton atbashButton = new JRadioButton("Atbash");
        atbashButton.addActionListener(this);
        atbashButton.setActionCommand("atbash");
        panel.add(atbashButton);
        cipherButtons.add(atbashButton);
        JRadioButton caesarButton = new JRadioButton("Caesar");
        caesarButton.setSelected(true);
        caesarButton.addActionListener(this);
        caesarButton.setActionCommand("caesar");
        panel.add(caesarButton);
        cipherButtons.add(caesarButton);
        JRadioButton vigenereButton = new JRadioButton("Vigènere");
        vigenereButton.addActionListener(this);
        vigenereButton.setActionCommand("vigenere");
        panel.add(vigenereButton);
        cipherButtons.add(vigenereButton);
        JRadioButton autokeyButton = new JRadioButton("Autokey");
        autokeyButton.addActionListener(this);
        autokeyButton.setActionCommand("autokey");
        panel.add(autokeyButton);
        cipherButtons.add(autokeyButton);
        JRadioButton otpButton = new JRadioButton("One-time pad");
        otpButton.addActionListener(this);
        otpButton.setActionCommand("OTP");
        panel.add(otpButton);
        cipherButtons.add(otpButton);
    }
}
