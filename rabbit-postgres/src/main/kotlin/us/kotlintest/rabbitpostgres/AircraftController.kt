package us.kotlintest.rabbitpostgres

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import us.kotlintest.rabbitpostgres.domain.Aircraft
import us.kotlintest.rabbitpostgres.domain.PairRefPart
import java.time.ZonedDateTime

@RestController
@RequestMapping("/api")
class AircraftController(@Autowired private val aircraftRepo : AircraftRepository,
                         @Autowired private val bootstrapService : BootstrapService) {


    @PostMapping("/bootstraping")
    @ResponseBody
    fun generateData(@RequestBody aircraft : Aircraft): ResponseEntity<Aircraft> {
        val dateTime = ZonedDateTime.now()
        val cont = 1000
        val token = "_$cont"
        val air11 = aircraftRepo.save(Aircraft(id = 0, aircraftId = "10-5012", tailNumber = "10001"))
        val air22 = aircraftRepo.save(Aircraft(id = 0, aircraftId = "10-5049", tailNumber = "10002"))
        bootstrapService.persistConfig(air11)
        return ResponseEntity.ok().body(air11);
    }
    @GetMapping("/pair")
    @ResponseBody
    fun generatePair() : ResponseEntity<String>{
        bootstrapService.persistPair()
        return ResponseEntity.ok("Done")
    }
    @GetMapping("/allpair")
    @ResponseBody
    fun getPairData() : ResponseEntity<List<PairRefPart>>{
        return ResponseEntity.ok(bootstrapService.getPairs())
    }
}