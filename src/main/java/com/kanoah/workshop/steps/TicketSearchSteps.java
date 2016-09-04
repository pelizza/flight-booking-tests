package com.kanoah.workshop.steps;

import com.kanoah.workshop.pages.TicketSearchPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

public class TicketSearchSteps {

    private final TicketSearchPage ticketSearchPage;

    public TicketSearchSteps(WebDriver webDriver) {
        ticketSearchPage = new TicketSearchPage(webDriver);
    }

    @Given("Eu quero viajar de $de para $para")
    public void dadoQueEuQueroViajarDeUmLugarAOutro(@Named("de") String de, @Named("para") String para) {
        ticketSearchPage.navegar();
        ticketSearchPage.setDe(de);
        ticketSearchPage.setPara(para);
    }

    @Given("a data de ida é $data")
    public void dadoQueADataDeIdaEh(@Named("data") String data) {
        ticketSearchPage.setIda(data);
    }

    @Given("a data de volta é $data")
    public void dadoQueADataDeVoltaEh(@Named("data") String data) {
        ticketSearchPage.setVolta(data);
    }

    @Given("o número de passageiros é $quantidade")
    public void dadoQueONumberoDePassageirosEh(@Named("quantidade") int quantidade) {
        ticketSearchPage.setPassageiros(quantidade);
    }

    @When("procuro por passagens")
    public void quandoProcuroPorPassagens() {
        ticketSearchPage.procurarPassagens();
    }

    @Then("devo encontrar uma passagem custando $custo")
    public void entaoDevoEncontrarPassagem(@Named("custo") String custo) {
        System.out.println("entaoDevoEncontrarPassagem: "+ custo);
    }
}
