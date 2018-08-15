package za.co.bbd.momentum.journalrest.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.momentum.journalrest.api.model.request.CreateJournalRequest;
import za.co.bbd.momentum.journalrest.dto.JournalDTO;
import za.co.bbd.momentum.journalrest.entity.Journal;
import za.co.bbd.momentum.journalrest.repo.JournalRepository;
import za.co.bbd.momentum.journalrest.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public JournalDTO fetchById(Long journalId) {
        Journal journal = journalRepository.getOne(journalId);
        if(journal == null) return null;
        return mapper.map(journal, JournalDTO.class);
    }

    @Override
    public List<JournalDTO> fetchAllByUserId(Long userId) {
        List<JournalDTO> response = new ArrayList<>();
        List<Journal> journals = journalRepository.findAllByUserId(userId);
        if(journals == null || journals.isEmpty()) {
            return response;
        }
        return journals.stream().map(journal -> mapper.map(journal, JournalDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<JournalDTO> fetchAll() {
        List<JournalDTO> response = new ArrayList<>();
        List<Journal> journals = journalRepository.findAll();
        if(journals == null || journals.isEmpty()) {
            return response;
        }
        return journals.stream().map(journal -> mapper.map(journal, JournalDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Long countAllByUserId(Long userId) {
        return journalRepository.countAllByUserId(userId);
    }

    @Override
    public void create(CreateJournalRequest createJournalRequest) {
        Journal journal = new Journal();
        journal.setTitle(createJournalRequest.getTitle());
        journal.setContent(createJournalRequest.getContent());
        journal.setUser(userRepository.getOne(createJournalRequest.getUserId()));
        journal.setCreatedOn(LocalDateTime.now());
        journalRepository.saveAndFlush(journal);
    }
}
