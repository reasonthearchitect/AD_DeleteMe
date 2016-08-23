package com.tek.myservice.test.rest

import com.tek.myservice.dto.Cat
import com.tek.myservice.rest.CatRest
import com.tek.myservice.stream.CatSource

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification


class CatRestSpec extends Specification {

    CatRest catRest;

    def setup() {
        this.catRest        = new CatRest();
        this.catRest.source = Mock(CatSource);
    }

    def "simple test for the rest endpoint"() {

        when:
        ResponseEntity responseEntity = this.catRest.process([] as Cat);

        then:
        1 * this.catRest.source.send(_);
        responseEntity != null;
        responseEntity.getStatusCode() == HttpStatus.CREATED;
    }
}
