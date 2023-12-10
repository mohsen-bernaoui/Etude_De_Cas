package tn.esprit.etude_de_cas.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.etude_de_cas.Entity.Chambre;
import tn.esprit.etude_de_cas.Reposity.ChambreRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CleaningServiceIMP implements ICleaning{
    private ChambreRepo chambreRepo;
    @Override
    public void scheduleCleaning(Chambre chambre) {
        int cleaningFrequencyInDays = 3;

        LocalDateTime lastCleaningDate = chambre.getLastCleaningDate();

        if (lastCleaningDate != null) {
            LocalDateTime nextScheduledCleaningDate = lastCleaningDate.plusDays(cleaningFrequencyInDays);
            chambre.setNextScheduledCleaningDate(nextScheduledCleaningDate);
            chambre.setCleaningScheduled(true);
            chambreRepo.save(chambre);
        }
    }

    @Override
    public void markRoomAsCleaned(Chambre chambre) {
        chambre.setLastCleaningDate(LocalDateTime.now());
        chambre.setCleaningScheduled(false);
        chambreRepo.save(chambre);
    }
}
