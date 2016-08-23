package com.tek.myservice.test.stream

import com.tek.myservice.dto.Cat
import com.tek.myservice.stream.CatSource

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.messaging.MessageChannel
import spock.lang.Specification

class CatSourceSpec extends Specification {

    CatSource catSource;

    def setup() {
        this.catSource           = new CatSource();
        this.catSource.mapper    = new ObjectMapper();
        this.catSource.post      = Mock(MessageChannel);
    }

    def "simple test for teh source"() {

        when:
        this.catSource.send([] as Cat);

        then:
        1 * this.catSource.post.send(_)
    }
}
