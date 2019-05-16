package de.qaware.buenavista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

@RestController
public class WoatamoiController {

    private Logger LOG = LoggerFactory.getLogger(WoatamoiController.class);

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @RequestMapping(value = "/woatamoi", method = RequestMethod.GET)
    public void woatamoi(
            @RequestParam(name = "url") String sUrl,
            @RequestParam(name = "delay") int delay) {
        LOG.info("Called service with URL " + sUrl + " and delay " + delay + ".");

        Callable<Integer> callable = () -> {
            LOG.info("Waiting " + delay + " seconds.");
            try {
                TimeUnit.SECONDS.sleep(delay);
                URL url = new URL(sUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int responseCode = connection.getResponseCode();

                LOG.info("Called " + sUrl + " with response code " + responseCode + ".");
                return responseCode;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new InvalidURLException(e);
            } catch (IOException e) {
                throw new ConnectException(e);
            }
        };

        executorService.submit(callable);


    }



}
