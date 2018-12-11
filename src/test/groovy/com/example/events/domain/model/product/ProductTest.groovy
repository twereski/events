package com.example.events.domain.model.product

import com.example.events.domain.model.Money
import com.example.events.domain.model.product.event.Bought
import com.example.events.domain.model.product.event.Paid
import spock.lang.Specification

class ProductTest extends Specification {
    def money = GroovyMock(Money)
    def product = new Product( UUID.randomUUID(), 'name', money)
    def "Buy"() {
        given:
        when:
        product.buy()
        then:
        product.getState() == ProductState.BOUGHT
        product.getCurrentVersion() == 2
        product.getEvents().get(2).class  == Bought.class
    }

    def "Pay"() {
        given:
        product.buy()
        when:
        product.pay()
        then:
        product.getState() == ProductState.PAID
        product.getCurrentVersion() == 3
        product.getEvents().get(3).class  == Paid.class
    }

}
