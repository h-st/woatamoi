package de.qaware.buenavista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LogController {

    Logger LOG = LoggerFactory.getLogger(LogController.class);

    @RequestMapping(value = "/log/*", method = RequestMethod.GET)
    public void log(HttpServletRequest request) {

        LOG.info("Called with path " + request.getRequestURI() + ".");
    }

}
