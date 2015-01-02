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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.*;
import logic.Logic;

/**
 *
 * @author korppi
 *
 * Luokka sisältää graafisen käyttöliittymän.
 */
public class GUI implements Runnable, ActionListener {

    private JFrame frame;
    //private boolean encryptMode;
    private JTextField plaintext;
    private JTextField ciphertext;
    private JTextField keytext;
    Logic logic;

    public GUI() {
        logic=new Logic();
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

    @Override
    public void actionPerformed(ActionEvent a) {
        String action = a.getActionCommand();
        if (action.equals("encrypt")) {
            logic.setEncryptMode(true);
        } else if (action.equals("decrypt")) {
           logic.setEncryptMode(false);
        } else if (action.equals("caesar")) {
            logic.setCipher(0);
        }
        plaintext.setEnabled(logic.getEncryptMode());
        ciphertext.setEnabled(!logic.getEncryptMode());
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

    public JFrame getFrame() {
        return frame;
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
        plaintext = new JTextField("The plaintext comes here");
        plaintext.setEnabled(true);
        panel.add(plaintext);
        ciphertext = new JTextField("The ciphertext comes here");
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
        keytext = new JTextField("The key comes here");
        panel.add(keytext);
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
        //encryptButton.addActionListener(this);
        //decryptButton.addActionListener(this);
    }

    private void initCipherMode(JPanel panel) {
        ButtonGroup cipherButtons = new ButtonGroup();
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel headline = new JLabel("Cipher:");
        panel.add(headline);
        JRadioButton caesarButton = new JRadioButton("Caesar");
        caesarButton.setSelected(true);
        panel.add(caesarButton);
        cipherButtons.add(caesarButton);
        //JRadioButton vignereButton = new JRadioButton("Vignere");
        //cipherMode.add(vignereButton);
        //cipherButtons.add(vignereButton);
        //JRadioButton playfairButton = new JRadioButton("Playfair");
        //cipherMode.add(playfairButton);
        //cipherButtons.add(playfairButton);
        //JRadioButton otpButton = new JRadioButton("One time pad");
        //cipherMode.add(otpButton);
        //cipherButtons.add(otpButton);
    }
}
