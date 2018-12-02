package com.example.events.domain.model.product

import com.example.events.domain.model.Money
import spock.lang.Specification

class ProductTest extends Specification {
    def "Buy"() {
        given:
        def money = GroovyMock(Money)
        def product = new Product(UUID.randomUUID(), 'name', money)
        when:
        product.buy()
        then:
        product.getState() == ProductState.BOUGHT
    }

    def "Pay"() {
        given:
        def money = GroovyMock(Money)
        def product = new Product(UUID.randomUUID(), 'name', money)
        product.buy()
        when:
        product.pay()
        then:
        product.getState() == ProductState.PAID
    }

    def "GetEvents"() {
    }

    def "ClearEvents"() {
    }

    def "GetCurrentVersion"() {
    }
}
