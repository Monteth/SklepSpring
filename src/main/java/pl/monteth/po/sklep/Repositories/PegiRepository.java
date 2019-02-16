package pl.monteth.po.sklep.Repositories;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.repository.CrudRepository;
import pl.monteth.po.sklep.Models.Pegi;

import java.util.Optional;

public interface PegiRepository extends CrudRepository<Pegi, Long> {
    @NotNull
    Optional<Pegi> findById(@Nullable Long idPegi);
}
