package com.example.events.app.product.container

import com.example.events.domain.model.product.Product
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

class ProductContainerServiceTest extends Specification {
    def "RetrieveFrom"() {
        given:
        def repo = Mock(ProductContainerRepository) {
            findOne(_) >> Mock(ProductContainer) {
                getPayLoad() >> "xd"
            }
        }
        def mapper = Mock(ObjectMapper) {
            readValue(_, Product.class) >> Mock(Product)
        }
        def service = new ProductContainerService(repo, mapper)
        when:
        def  product = service.retrieveFrom(UUID.randomUUID())
        then:
        1 * mapper.readValue(_,_)

    }

    def "Save"() {
    }
}
