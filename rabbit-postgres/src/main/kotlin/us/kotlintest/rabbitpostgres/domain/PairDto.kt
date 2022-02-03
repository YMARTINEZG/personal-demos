package us.kotlintest.rabbitpostgres.domain

interface PairDto {
    val partNumber : String
    val cageCode : String
    val typeMeasure : String
    val hours : Int
}
