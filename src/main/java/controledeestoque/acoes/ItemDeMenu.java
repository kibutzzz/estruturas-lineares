package controledeestoque.acoes;

import java.util.function.Consumer;

public interface ItemDeMenu<T> extends Consumer<T> {
    String getNome();
}
