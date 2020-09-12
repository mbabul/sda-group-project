package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainAction implements MenuAction {

  private final CustomScanner scanner;
  private final MenuActionContext ctx;
  private final MainActionStrategy strategy;

  @Override
  public void execute() {
    System.out.println("0) Zamknij aplikację");
    System.out.println("1) Dodaj miasto");
    System.out.println("2) Wyswietl miasta");

    var input = scanner.nextLine();

    strategy
        .prepareCtx(input, ctx)
        .ifPresentOrElse(
            MenuActionContext::execute,
            () -> {
              System.out.println("Wprowadzono nieprawidłowa wartość!");
              execute();
            });
  }
}
