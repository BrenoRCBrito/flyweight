package com.brenobrito;

public final class Glifo
{

  private final char caractere;
  private final String fonte;

  Glifo(char caractere, String fonte)
  {
    this.caractere = caractere;
    this.fonte = fonte;
  }

  public char getCaractere()
  {
    return this.caractere;
  }

  public String getFonte()
  {
    return this.fonte;
  }

  public String imprimir(int linha, int coluna, int tamanho)
  {
    return this.caractere + "@" + linha + "," + coluna + ":" + tamanho + "pt/" + this.fonte;
  }
}
