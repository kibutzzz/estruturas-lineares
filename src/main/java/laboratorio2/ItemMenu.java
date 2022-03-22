package laboratorio2;

import java.util.function.Consumer;

public class ItemMenu {

  private final String descricao;
  private final Consumer<Mapa> acao;
  private final Mapa mapa;

  public ItemMenu(String descricao, Consumer<Mapa> acao, Mapa mapa) {
    this.descricao = descricao;
    this.acao = acao;
    this.mapa = mapa;
  }

  public String getDescricao() {
    return descricao;
  }

  public void executar() {
    acao.accept(mapa);
  }
}
