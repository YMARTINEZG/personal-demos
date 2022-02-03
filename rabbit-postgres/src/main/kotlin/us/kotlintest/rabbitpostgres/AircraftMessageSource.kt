package us.kotlintest.rabbitpostgres

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

interface AircraftMessageSource {
    @Input
    fun input(): SubscribableChannel?
}