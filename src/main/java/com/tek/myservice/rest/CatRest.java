package com.tek.myservice.rest; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tek.myservice.stream.CatSource;
import com.tek.myservice.dto.Cat;

@RestController
@RequestMapping("/cats")
public class CatRest {

        @Autowired
        private CatSource source;


        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<?> process(@RequestBody Cat cat ) {
                source.send(cat);

                HttpHeaders httpHeaders = new HttpHeaders();

                /* - Uncomment to add some additional headers.
                httpHeaders.setLocation(ServletUriComponentsBuilder
                                .fromCurrentRequest().path("/{id}")
                                .buildAndExpand(cat.getId()).toUri());
                */
                return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        }
}
