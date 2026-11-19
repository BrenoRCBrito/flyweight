package com.brenobrito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoTest
{

  private Documento documento;

  @BeforeEach
  void abrirODocumento()
  {
    this.documento = new Documento();
  }

  @Test
  void deveReaproveitarOsGlifosRepetidos()
  {
    documento.escrever("banana", "Serif", 0, 12);

    assertEquals(6, documento.totalDeCaracteres());
    assertEquals(3, documento.glifosDistintos());
  }

  @Test
  void deveApontarParaOMesmoGlifoEmColunasDiferentes()
  {
    documento.escrever("banana", "Serif", 0, 12);

    assertSame(documento.glifoEm(1), documento.glifoEm(3));
    assertSame(documento.glifoEm(1), documento.glifoEm(5));
  }

  @Test
  void deveRenderizarComOEstadoExtrinseco()
  {
    documento.escrever("ana", "Serif", 2, 14);

    assertEquals("a@2,0:14pt/Serif n@2,1:14pt/Serif a@2,2:14pt/Serif", documento.renderizar());
  }

  @Test
  void deveCompartilharGlifosEntreLinhas()
  {
    documento.escrever("banana", "Serif", 0, 12);
    documento.escrever("banana", "Serif", 1, 12);

    assertEquals(12, documento.totalDeCaracteres());
    assertEquals(3, documento.glifosDistintos());
    assertSame(documento.glifoEm(0), documento.glifoEm(6));
  }

  @Test
  void deveCriarNovosGlifosParaOutraFonte()
  {
    documento.escrever("banana", "Serif", 0, 12);
    documento.escrever("banana", "Mono", 1, 12);

    assertEquals(6, documento.glifosDistintos());
  }

  @Test
  void deveManterOGlifoMesmoComTamanhosDiferentes()
  {
    documento.escrever("a", "Serif", 0, 12);
    documento.escrever("a", "Serif", 1, 48);

    assertEquals(1, documento.glifosDistintos());
    assertSame(documento.glifoEm(0), documento.glifoEm(1));
    assertTrue(documento.renderizar().contains("48pt"));
  }

  @Test
  void deveComecarVazio()
  {
    assertEquals(0, documento.totalDeCaracteres());
    assertEquals(0, documento.glifosDistintos());
    assertEquals("", documento.renderizar());
  }
}
