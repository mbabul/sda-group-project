package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.entity.City;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCityAction implements MenuAction {

  private final CustomScanner scanner;
  private final MenuActionContext ctx;
  private final CityRepository repository;

  @Override
  public void execute() {
    System.out.println("0) Przejdź do poprzedniego menu");
    System.out.println("Podaj nazwę miasta:");

    var input = scanner.nextLine();

    if (pressedZero(input)) return;

    var builder = City.builder().name(input);

    System.out.println("Podaj nazwę państwa:");

    input = scanner.nextLine();

    if (pressedZero(input)) return;

    var city = builder.country(input).build();

    repository.create(city);
    ctx.use(MainAction.class).execute();
  }

  private boolean pressedZero(String input) {
    if (input.equals("0")) {
      ctx.use(MainAction.class).execute();
      return true;
    }
    return false;
  }
}
