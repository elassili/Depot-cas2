package ma.example.microservicecommande.repository;

import ma.example.microservicecommande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
