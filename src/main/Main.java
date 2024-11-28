package main;

import view.MainMenu;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
