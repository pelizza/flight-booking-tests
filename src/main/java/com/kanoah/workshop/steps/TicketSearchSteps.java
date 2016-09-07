package com.kanoah.workshop.steps;

import com.kanoah.workshop.pages.TicketResultsPage;
import com.kanoah.workshop.pages.TicketSearchPage;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TicketSearchSteps {

    private final TicketSearchPage ticketSearchPage;
    private final TicketResultsPage ticketResultsPage;

    public TicketSearchSteps(WebDriver webDriver) {
        ticketSearchPage = new TicketSearchPage(webDriver);
        ticketResultsPage = new TicketResultsPage(webDriver);
    }

    @Given("eu estou na página de busca de passagens")
    public void estouNaPaginaDeBuscaDePassagens() {
        ticketSearchPage.navegar();
    }

    @When("eu quero viajar de $de para $para")
    public void dadoQueEuQueroViajarDeUmLugarAOutro(@Named("de") String de, @Named("para") String para) {
        ticketSearchPage.setDe(de);
        ticketSearchPage.setPara(para);
    }

    @When("a data de ida é $data")
    @Alias("a data de ida é <data>")
    public void dadoQueADataDeIdaEh(@Named("data") String data) {
        ticketSearchPage.setIda(data);
    }

    @When("a data de volta é $data")
    @Alias("a data de volta é <data>")
    public void dadoQueADataDeVoltaEh(@Named("data") String data) {
        ticketSearchPage.setVolta(data);
    }

    @When("o número de passageiros é $quantidade")
    @Alias("o número de passageiros é <quantidade>")
    public void dadoQueONumberoDePassageirosEh(@Named("quantidade") int quantidade) {
        ticketSearchPage.setPassageiros(quantidade);
    }

    @When("procuro por passagens")
    public void quandoProcuroPorPassagens() {
        ticketSearchPage.procurarPassagens();
    }

    @Then("devo encontrar passagens de ida e volta custando $custo_ida e $custo_volta")
    @Alias("devo encontrar passagens de ida e volta custando <custo_ida> e <custo_volta>")
    public void entaoDevoEncontrarPassagem(@Named("custo_ida") String custoIda, @Named("custo_volta") String custoVolta) {
        Assert.assertEquals(custoIda, ticketResultsPage.getCustoDaPassagem(1));
        Assert.assertEquals(custoVolta, ticketResultsPage.getCustoDaPassagem(2));
    }
}
