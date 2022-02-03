package us.kotlintest.rabbitpostgres.domain

import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name="aircrafts")
data class Aircraft(
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        val id: Long,
        val aircraftId: String,
        val tailNumber: String
)