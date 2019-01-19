package pl.monteth.po.sklep.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.monteth.po.sklep.Models.Patron;
public interface PatronRepository extends CrudRepository<Patron, Long> {

//    public Iterable findAllByIdPatron(Long idPatron);

}
