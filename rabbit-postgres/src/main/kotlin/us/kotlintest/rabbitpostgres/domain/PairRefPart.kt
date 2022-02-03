package us.kotlintest.rabbitpostgres.domain

import javax.persistence.Entity
import us.kotlintest.rabbitpostgres.domain.PairDto
import javax.persistence.Id

@Entity(name="pair_ref_part")
data class PairRefPart(
        @Id
        override val partNumber : String,
        override val cageCode : String,
        override val typeMeasure : String,
        override val hours : Int
) : PairDto