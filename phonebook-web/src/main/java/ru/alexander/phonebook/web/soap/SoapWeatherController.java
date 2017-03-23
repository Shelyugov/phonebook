package ru.alexander.phonebook.web.soap;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * SOAP-контроллер, использующий внешний soap-сервис.
 *
 * @see <a href="http://www.webservicex.com/New/Home/ServiceDetail/56">GlobalWeather service description</a>
 * @see <a href="http://www.webservicex.com/globalweather.asmx?wsdl">GlobalWeather WSDL file</a>
 */

@WebService
public class SoapWeatherController {

    private static final String COUNTRY = "Russia";

    private final GlobalWeather soap = new GlobalWeather();

    @WebMethod
    public String getWeather(@WebParam(name = "city") String city) {
        final GlobalWeatherSoap service = soap.getGlobalWeatherSoap();
        return service.getWeather(city, COUNTRY);
    }

    @WebMethod
    public String getCities() {
        final GlobalWeatherSoap service = soap.getGlobalWeatherSoap();
        return service.getCitiesByCountry(COUNTRY);
    }
}
