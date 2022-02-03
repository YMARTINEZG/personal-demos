package us.kotlintest.rabbitpostgres.domain

import javax.persistence.*

@Entity(name="parts")
data class Part(
        @Id @GeneratedValue(strategy= GenerationType.AUTO)
        val id : Long,
        val partNumber: String,
        val serialNumber: String,
        val cageCode : String)
