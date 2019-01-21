package pl.monteth.po.sklep.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.monteth.po.sklep.Models.Pupil;

import java.util.List;

public interface PupilRepository extends CrudRepository<Pupil, Long> {

    @Query(
            value = "select * from Pupil where patron_id_patron = ?1",
            nativeQuery = true)
    public List<Pupil> findPupilsIdByPatronId(Long id);
}
