package ma.example.microservicecommande.service;

import ma.example.microservicecommande.model.Commande;
import ma.example.microservicecommande.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande updateCommande(Long id, Commande updatedCommande) {
        return commandeRepository.findById(id).map(commande -> {
            commande.setDescription(updatedCommande.getDescription());
            commande.setQuantite(updatedCommande.getQuantite());
            commande.setDate(updatedCommande.getDate());
            commande.setMontant(updatedCommande.getMontant());
            commande.setIdProduit(updatedCommande.getIdProduit());
            return commandeRepository.save(commande);
        }).orElseThrow(() -> new RuntimeException("Commande non trouvée"));
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
