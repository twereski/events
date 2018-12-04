package com.example.events.app.product.container

import com.example.events.domain.model.product.Product
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

class ProductContainerServiceTest extends Specification {
    def "RetrieveFrom"() {
        given:
        def container = Mock(ProductContainer) {
            getPayLoad() >> "xd"
        }
        def repo = Mock(ProductContainerRepository) {
            findById(_) >> Optional.of(container)

        }
        def mapper = Mock(ObjectMapper) {
            readValue(*_) >> Mock(Product)
        }
        def service = new ProductContainerService(repo, mapper)
        when:
        service.retrieveFrom(UUID.randomUUID())
        then:
        1 * mapper.readValue(_,_)

    }

    def "Save"() {
    }
}
