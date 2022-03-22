package laboratorio2;

import java.util.Objects;

public class MenuUi {

  private final ItemMenu[] itensMenu;
  private boolean sair = false;

  public MenuUi(ItemMenu[] opcoes) {
    itensMenu = opcoes;
  }

  public void mostrarOpcoes() {
    for (int i = 0; i < itensMenu.length; i++) {
      final var item = itensMenu[i];
      if (Objects.isNull(item)) {
        continue;
      }

      System.out.println(i + " - " + itensMenu[i].getDescricao());
    }
  }

  public void selecionar(int i) {
    try {
      itensMenu[i].executar();
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }

  public void setSaida(boolean deveSair) {
    this.sair = deveSair;
  }

  public boolean getSaida() {
    return this.sair;
  }
}
