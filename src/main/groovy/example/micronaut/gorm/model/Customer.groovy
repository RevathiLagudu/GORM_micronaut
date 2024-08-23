package example.micronaut.gorm.model

import example.micronaut.gorm.domain.Address

class Customer {
    String name
    Set<Address> address
}
