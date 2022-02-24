package com.revature.foundation.screens;

import com.revature.foundation.util.AppState;
import com.revature.foundation.util.ScreenRouter;

import java.io.BufferedReader;
import java.io.IOException;

public class WelcomeScreen extends Screen {

    private ScreenRouter screenRouter;

    public WelcomeScreen(BufferedReader consoleReader, ScreenRouter router) {
        super("/welcome", consoleReader);
        this.screenRouter = router;
    }

    @Override
    public void render() throws IOException {

        String welcomeMenu = "Welcome to the Server!\n" +
                "Please make a selection from the options below:\n" +
                "1) Login\n" +
                "2) Register\n" +
                "3) Exit\n" +
                "> ";

        System.out.print(welcomeMenu);

        String userSelection = consoleReader.readLine();

        switch (userSelection) {
            case "1":
                screenRouter.navigate("/login");
                break;
            case "2":
                screenRouter.navigate("/register");
                break;
            case "3":
                AppState.shutdown();
                return;
            default:
                System.out.println("You have made an incorrect selection");
        }

    }

}
