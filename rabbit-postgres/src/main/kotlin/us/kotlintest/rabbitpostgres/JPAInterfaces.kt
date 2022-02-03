package us.kotlintest.rabbitpostgres

import org.springframework.data.jpa.repository.JpaRepository
import us.kotlintest.rabbitpostgres.domain.*

interface AircraftRepository : JpaRepository<Aircraft, Long>
interface AircraftConfigRepository : JpaRepository<AircraftConfig, Long>
interface PartRepository : JpaRepository<Part, Long>
interface RefPartRepository : JpaRepository<RefPart, Long>
interface PairDatasetRepository : JpaRepository<PairDataset, Long>
interface PairRefPartRepository : JpaRepository<PairRefPart, String>