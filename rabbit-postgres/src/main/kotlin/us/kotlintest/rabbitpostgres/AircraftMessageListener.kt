package us.kotlintest.rabbitpostgres

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink

@EnableBinding(AircraftMessageSource::class)
class AircraftMessageListener {
    @StreamListener(Sink.INPUT)
    fun handle(message: String?) {
        println(message)
    }
}

