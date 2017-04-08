package ru.alexander.phonebook.web.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Сервис, использующий внешний REST-сервис.
 *
 * @see <a href="http://fixer.io/">Конвертер валют fixer.io</a>
 */
@Path("/external")
public class ExternalHTTPService {
    /**
     * URL запроса
     */
    private static final String RESOURCE_URI = "http://api.fixer.io";

    /**
     * Валюта по умолчанию
     */
    private static final String ROUBLES = "RUB";

    /**
     * Дата по умолчанию
     */
    private static final String DEFAULT_DATE = "latest";

    @GET
    @Path("/currency")
    public Response getCurrency(@PathParam("date") @DefaultValue(DEFAULT_DATE) String date) {
        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target(RESOURCE_URI).path(date).queryParam("base", ROUBLES);
        return target.request().get();
    }
}
