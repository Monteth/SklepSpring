package pl.monteth.po.sklep.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.monteth.po.sklep.Models.Software;

import java.util.List;

public interface SoftwareRepository extends CrudRepository<Software, Long> {


    @Query(
            value = "select * from Software where lower(name) like (lower(?1)) order by random() limit ?2",
            nativeQuery = true
    )
    public Iterable<Software> findSoftwaresByNameLike(String name, Integer limit);

    @Query(
            value = "select * from Software order by random() limit ?1",
            nativeQuery = true)
    public Iterable<Software> findRandomSoftware(Integer limit);
}
