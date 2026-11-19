package com.brenobrito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Documento
{

  private final GlifoFactory fabrica = new GlifoFactory();
  private final List<CaractereImpresso> caracteres = new ArrayList<>();

  public void escrever(String texto, String fonte, int linha, int tamanho)
  {
    for (int coluna = 0; coluna < texto.length(); coluna++)
    {
      Glifo glifo = this.fabrica.obter(texto.charAt(coluna), fonte);
      this.caracteres.add(new CaractereImpresso(glifo, linha, coluna, tamanho));
    }
  }

  public int totalDeCaracteres()
  {
    return this.caracteres.size();
  }

  public int glifosDistintos()
  {
    return this.fabrica.glifosCriados();
  }

  public Glifo glifoEm(int indice)
  {
    return this.caracteres.get(indice).getGlifo();
  }

  public String renderizar()
  {
    return this.caracteres.stream()
      .map(CaractereImpresso::imprimir)
      .collect(Collectors.joining(" "));
  }
}
