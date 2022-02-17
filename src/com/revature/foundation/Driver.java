package com.revature.foundation;

import com.revature.foundation.screens.LoginScreen;
import com.revature.foundation.screens.RegisterScreen;
import com.revature.foundation.screens.WelcomeScreen;
import java.io.*;

public class Driver {

    private static int loopCounter = 0;

    public static void main(String[] args) {

        // TODO: at the start of the program, read in our users file, and store them in some sort of container, or Data Structure

        if (loopCounter == 3) {
            throw new RuntimeException("Looped three times");
        }

        new WelcomeScreen().render();

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {

            String userSelection = consoleReader.readLine();
            System.out.println(userSelection);

            switch (userSelection) {
                case "1":
                    new LoginScreen().render();
                    break;
                case "2": // TODO there are better ways, all in due time
                    new RegisterScreen().render();
                    break;
                case "3":
                    return;

                default:
                    System.out.println("You have made an incorrect selection");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        loopCounter++;
        main(args); // TODO maybe don't use recursion here?
    }

}