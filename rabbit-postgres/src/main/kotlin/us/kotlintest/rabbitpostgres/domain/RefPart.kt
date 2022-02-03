package us.kotlintest.rabbitpostgres.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name="ref_parts")
data class RefPart(
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        val id : Long,
        val partNumber : String,
        val cageCode : String,
        val drawfingCode : String
)