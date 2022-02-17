package com.revature.foundation.screens;

import java.io.IOException;

public class WelcomeScreen extends Screen {

    public WelcomeScreen() {
        super("/welcome");
    }

    @Override
    public void render() {
         String welcomeMenu = "Welcome to Quizzard!\n" +
                             "Please make a selection from the options below:\n" +
                             "1) Login\n" +
                             "2) Register\n" +
                             "3) Exit\n" +
                             "> ";

        System.out.print(welcomeMenu);

    }

}
