package com.brenobrito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GlifoFactoryTest
{

  private GlifoFactory fabrica;

  @BeforeEach
  void prepararAFabrica()
  {
    this.fabrica = new GlifoFactory();
  }

  @Test
  void deveCompartilharOMesmoGlifo()
  {
    assertSame(fabrica.obter('A', "Serif"), fabrica.obter('A', "Serif"));
    assertEquals(1, fabrica.glifosCriados());
  }

  @Test
  void deveSepararGlifosPorCaractere()
  {
    assertNotSame(fabrica.obter('A', "Serif"), fabrica.obter('B', "Serif"));
    assertEquals(2, fabrica.glifosCriados());
  }

  @Test
  void deveSepararGlifosPorFonte()
  {
    assertNotSame(fabrica.obter('A', "Serif"), fabrica.obter('A', "Mono"));
    assertEquals(2, fabrica.glifosCriados());
  }

  @Test
  void deveContarApenasOsGlifosDistintos()
  {
    for (char caractere : "banana".toCharArray())
    {
      fabrica.obter(caractere, "Serif");
    }

    assertEquals(3, fabrica.glifosCriados());
  }

  @Test
  void deveGuardarOEstadoIntrinseco()
  {
    Glifo glifo = fabrica.obter('A', "Serif");

    assertEquals('A', glifo.getCaractere());
    assertEquals("Serif", glifo.getFonte());
  }

  @Test
  void deveReceberOEstadoExtrinsecoNaImpressao()
  {
    Glifo glifo = fabrica.obter('A', "Serif");

    assertEquals("A@0,0:12pt/Serif", glifo.imprimir(0, 0, 12));
    assertEquals("A@3,7:24pt/Serif", glifo.imprimir(3, 7, 24));
  }

  @Test
  void deveComecarSemNenhumGlifo()
  {
    assertEquals(0, fabrica.glifosCriados());
  }
}
