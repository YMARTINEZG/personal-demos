package us.kotlintest.rabbitpostgres.domain

import java.time.ZonedDateTime
import javax.persistence.*

@Entity(name="aircraft_config")
data class AircraftConfig(
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        val id: Long,
        val aircraftId: String,
        val lcn: String,
        val actionType: String,
        val actionTime: ZonedDateTime,
        @ManyToOne
        var part : Part
)
