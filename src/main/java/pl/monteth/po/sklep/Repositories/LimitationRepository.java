package pl.monteth.po.sklep.Repositories;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.monteth.po.sklep.Models.Limitation;

public interface LimitationRepository extends CrudRepository<Limitation, Long> {

    @NotNull
    @Query(
            value = "select * " +
                    "from limitation lim " +
                    "right join limit_restriction lr " +
                    "on lim.id_limit = lr.limitation_id_limit " +
                    "where lr.pupil_id_pupil = ?1",
            nativeQuery = true
    )
    Iterable<Limitation> findAllByPupilId(long pupilId);

    Iterable<Limitation> findByIdLimitIn(Iterable<Long> ids);
}
