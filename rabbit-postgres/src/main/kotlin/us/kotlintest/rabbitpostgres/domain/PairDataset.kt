package us.kotlintest.rabbitpostgres.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "pair_data_set")
data class PairDataset(
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        val id : Long,
        val engineerId : String,
        val measure : String,
        val value : Int
)