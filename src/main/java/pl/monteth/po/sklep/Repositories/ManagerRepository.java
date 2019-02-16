package pl.monteth.po.sklep.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.monteth.po.sklep.Models.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
}
