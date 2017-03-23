package ru.alexander.phonebook.web.soap;

import net.webservicex.GlobalWeather;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * SOAP-контроллер, использующий внешний soap-сервис.
 * @see <a href="http://www.webservicex.com/New/Home/ServiceDetail/56">GlobalWeather service description</a>
 * @see <a href="http://www.webservicex.com/globalweather.asmx?wsdl">GlobalWeather WSDL file</a>
 */

@WebService
public class SoapWeatherController {

    private final GlobalWeather soap = new GlobalWeather();

    @WebMethod
    public Object getGlobalWeatherSoap() {
        return soap.getGlobalWeatherSoap();
    }
}
