package us.kotlintest.rabbitpostgres

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import us.kotlintest.rabbitpostgres.domain.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

@Service
class BootstrapService(@Autowired private val repoConfig: AircraftConfigRepository,
                       @Autowired private val repoPart: PartRepository,
                       @Autowired private val repoPair: PairDatasetRepository,
                       @Autowired private val repoRef: RefPartRepository,
                       @Autowired private val repoView : PairRefPartRepository ) {

    fun persistConfig(aircraft: Aircraft): Boolean{
        val dateTime = ZonedDateTime.now()
        var token = ""
        for( cont in 1000 until 2000) {
            token = "_$cont"
            val part1 = repoPart.save(Part(id = 0, partNumber = "pn${token}", serialNumber = "sn${token}", cageCode="cg${token}"))
            val config1 = repoConfig.save(AircraftConfig(id=0,aircraftId = aircraft.aircraftId,lcn ="lcn${token}", actionType = "Installed", actionTime = dateTime.minus((cont % 10).toLong(), ChronoUnit.DAYS),part = part1))
            println(config1)
        }
        println("end process")
        return true
    }
    fun persistPair(): Boolean {
        repoRef.save(RefPart(id=0, partNumber = "pn_1010", cageCode = "cg_1010", drawfingCode = "pair_1010" ))
        repoPair.save(PairDataset(id=0, engineerId = "pair_1010", measure = "hours", value = 10))
        repoRef.save(RefPart(id=0, partNumber = "pn_1020", cageCode = "cg_1020", drawfingCode = "pair_1020" ))
        repoPair.save(PairDataset(id=0, engineerId = "pair_1020", measure = "hours", value = 10))
        repoRef.save(RefPart(id=0, partNumber = "pn_1030", cageCode = "cg_1030", drawfingCode = "pair_1030" ))
        repoRef.save(RefPart(id=0, partNumber = "pn_0055", cageCode = "cg_0055", drawfingCode = "pair_0055" ))
        repoRef.save(RefPart(id=0, partNumber = "pn_0080", cageCode = "cg_0080", drawfingCode = "pair_1010" ))
        repoPair.save(PairDataset(id=0, engineerId = "pair_1030", measure = "hours", value = 10))
        repoPair.save(PairDataset(id=0, engineerId = "pair_2030", measure = "hours", value = 6))
        repoPair.save(PairDataset(id=0, engineerId = "pair_0090", measure = "hours", value = 12))
        return true
    }
    fun getPairs() : List<PairRefPart> {
        return repoView.findAll()
    }
}