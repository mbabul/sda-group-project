package io.mbab.sda.groupproject.menu.action;

import io.mbab.sda.groupproject.entity.City;
import io.mbab.sda.groupproject.menu.CustomScanner;
import io.mbab.sda.groupproject.menu.MenuActionContext;
import io.mbab.sda.groupproject.repository.CityRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class CreateCityActionTest {

  @Test
  void shouldNotCreateCityAndExecuteMainAction() {
    // given
    var scanner = mock(CustomScanner.class);
    var actionCtx = mock(MenuActionContext.class);
    var repository = mock(CityRepository.class);
    var testedAction = new CreateCityAction(scanner, actionCtx, repository);

    when(scanner.nextLine()).thenReturn("0");
    when(actionCtx.use(MainAction.class)).thenReturn(actionCtx);

    // when
    testedAction.execute();

    // then
    verify(actionCtx, times(1)).execute();
    verify(repository, never()).create(any(City.class));
  }

  @Test
  void shouldCreateCity() {
    // given
    var city = "Lublin";
    var country = "Polska";
    var scanner = mock(CustomScanner.class);
    var actionCtx = mock(MenuActionContext.class);
    var repository = mock(CityRepository.class);
    var testedAction = new CreateCityAction(scanner, actionCtx, repository);

    when(scanner.nextLine()).thenReturn(city, country);
    when(actionCtx.use(MainAction.class)).thenReturn(actionCtx);

    // when
    testedAction.execute();

    // then
    verify(repository, times(1)).create(City.builder().name(city).country(country).build());
  }
}
