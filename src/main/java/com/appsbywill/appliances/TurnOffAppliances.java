package com.appsbywill.appliances;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class TurnOffAppliances {

    /**
     * This method makes a request to our internal library that controls the
     * lights, and turns them the hell off.
     *
     * @return
     */
    @RequestMapping("/turnOffBathroomLight")
    public ResponseEntity turnOffBathroomLight() throws IOException {
        //do the turn off lights shit
        turnOffBathroomLightCMD();
        return ResponseEntity.ok().build();
    }

    private void turnOffBathroomLightCMD() throws IOException{
         final String pathForCodesend = "/var/www/rfoutlet/codesend";
         Runtime.getRuntime().exec(new String[] { "/var/www/rfoutlet/codesend","72972", "-p", "0", "-l", "189"});
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TurnOffAppliances.class, args);
    }
}
