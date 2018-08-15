package za.co.bbd.momentum.journalrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.momentum.journalrest.entity.Journal;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {

    Long countAllByUserId(Long userId);

    List<Journal> findAllByUserId(Long userId);
}
