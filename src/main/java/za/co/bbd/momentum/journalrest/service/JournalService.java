package za.co.bbd.momentum.journalrest.service;

import za.co.bbd.momentum.journalrest.api.model.request.CreateJournalRequest;
import za.co.bbd.momentum.journalrest.dto.JournalDTO;

import java.util.List;

public interface JournalService {

    List<JournalDTO> fetchAllByUserId(Long userId);
    List<JournalDTO> fetchAll();

    Long countAllByUserId(Long userId);

    void create(CreateJournalRequest createJournalRequest);
}
