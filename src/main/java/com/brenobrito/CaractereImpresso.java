package com.brenobrito;

public class CaractereImpresso
{

  private final Glifo glifo;
  private final int linha;
  private final int coluna;
  private final int tamanho;

  public CaractereImpresso(Glifo glifo, int linha, int coluna, int tamanho)
  {
    this.glifo = glifo;
    this.linha = linha;
    this.coluna = coluna;
    this.tamanho = tamanho;
  }

  public Glifo getGlifo()
  {
    return this.glifo;
  }

  public String imprimir()
  {
    return this.glifo.imprimir(this.linha, this.coluna, this.tamanho);
  }
}
