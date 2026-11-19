package com.brenobrito;

import java.util.HashMap;
import java.util.Map;

public class GlifoFactory
{

  private final Map<String, Glifo> compartilhados = new HashMap<>();

  public Glifo obter(char caractere, String fonte)
  {
    String chave = caractere + "/" + fonte;
    return this.compartilhados.computeIfAbsent(chave, _ -> new Glifo(caractere, fonte));
  }

  public int glifosCriados()
  {
    return this.compartilhados.size();
  }
}
