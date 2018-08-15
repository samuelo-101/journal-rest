package za.co.bbd.momentum.journalrest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.momentum.journalrest.api.model.request.CreateJournalRequest;
import za.co.bbd.momentum.journalrest.api.model.request.response.JournalCountResponse;
import za.co.bbd.momentum.journalrest.dto.JournalDTO;
import za.co.bbd.momentum.journalrest.service.JournalService;

import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping("/{id}")
    public ResponseEntity<JournalDTO> fetchById(@PathVariable("id") Long journalId) {
        JournalDTO journalDTO = journalService.fetchById(journalId);
        return new ResponseEntity<>(journalDTO, HttpStatus.OK);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<JournalDTO>> fetchAllForUser(@PathVariable("userId") Long userId) {
        List<JournalDTO> journalDTOs = journalService.fetchAllByUserId(userId);
        return  new ResponseEntity<>(journalDTOs, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<JournalDTO>> fetchAll() {
        List<JournalDTO> journalDTOs = journalService.fetchAll();
        return  new ResponseEntity<>(journalDTOs, HttpStatus.OK);
    }

    @GetMapping("/count/{userId}")
    public ResponseEntity<JournalCountResponse> count(@PathVariable("userId") Long userId) {
        Long count = journalService.countAllByUserId(userId);
        return new ResponseEntity<>(new JournalCountResponse(count), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody CreateJournalRequest createJournalRequest) {
        journalService.create(createJournalRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
