package io.mbab.sda.groupproject.menu.action;

import java.util.Scanner;

public interface MenuAction {

    Scanner scanner = new Scanner(System.in);

    void execute();
}
