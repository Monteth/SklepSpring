package pl.monteth.po.sklep.Services

import org.springframework.stereotype.Service
import pl.monteth.po.sklep.Models.Limitation
import pl.monteth.po.sklep.Models.Pupil
import pl.monteth.po.sklep.Repositories.LimitationRepository
import pl.monteth.po.sklep.Repositories.PatronRepository
import pl.monteth.po.sklep.Repositories.PegiRepository
import pl.monteth.po.sklep.Repositories.PupilRepository
import pl.monteth.po.sklep.SimplyfiedModels.SimpPupil
import java.util.*

@Service
class PupilService(
        private val pupilRepository: PupilRepository,
        private val limitationRepository: LimitationRepository,
        private val patronRepository: PatronRepository,
        private val pegiRepository: PegiRepository) {

    fun getPupilLimitations(pupilId: Long): Iterable<Limitation> {
        return limitationRepository.findAllByPupilId(pupilId)
    }

    fun getPupil(pupilId: Long): Optional<Pupil> {
        return pupilRepository.findById(pupilId)
    }

    fun getPupils(): Iterable<Pupil> {
        return pupilRepository.findAll()
    }

    fun savePupil(pupil: Pupil): Boolean {
        var result = false
        if (isPupilValid(pupil)) {
            pupilRepository.save(pupil)
            result = true
        }
        return result
    }

    private fun isPupilValid(pupil: Pupil): Boolean {
        return true
    }

    fun saveSimpPupil(simpPupil: SimpPupil): Boolean {

        val pegi = pegiRepository.findById(simpPupil.pegi)
        val patron = patronRepository.findById(simpPupil.patron)
        val limitations: Iterable<Limitation> = limitationRepository.findByIdLimitIn(simpPupil.limitations)

        var result = false
        if (pegi.isPresent && patron.isPresent) {
            val pupil = Pupil(simpPupil.idPupil, simpPupil.email, simpPupil.firstName, simpPupil.lastName, pegi.get(), patron.get(), limitations as MutableList<Limitation>?)
            if (isPupilValid(pupil)) {
                println(pupil)
                result = savePupil(pupil)
            }
        }
        return result
    }
}