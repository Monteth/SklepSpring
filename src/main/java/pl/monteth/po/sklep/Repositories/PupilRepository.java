package pl.monteth.po.sklep.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.monteth.po.sklep.Models.Limitation;
import pl.monteth.po.sklep.Models.Pupil;

import java.util.List;

public interface PupilRepository extends CrudRepository<Pupil, Long> {

    @Query(
            value = "select * from Pupil where patron_id_patron = ?1",
            nativeQuery = true)
    public List<Pupil> findPupilsIdByPatronId(Long id);

//    @Query(
//            value = "select * " +
//                    "from limitation lim " +
//                    "right join limit_restriction lr " +
//                    "on lim.id_limit = lr.limitation_id_limit " +
//                    "where lr.pupil_id_pupil = ?1",
//            nativeQuery = true
//    )
//    public List<Limitation> findLimitByPupilId(Long id);'
}