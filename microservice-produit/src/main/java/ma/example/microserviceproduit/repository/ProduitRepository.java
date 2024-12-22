package ma.example.microserviceproduit.repository;

import ma.example.microserviceproduit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}