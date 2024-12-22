package ma.example.microserviceproduit.service;

import ma.example.microserviceproduit.model.Produit;
import ma.example.microserviceproduit.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Long id, Produit updatedProduit) {
        return produitRepository.findById(id).map(produit -> {
            produit.setNom(updatedProduit.getNom());
            produit.setPrix(updatedProduit.getPrix());
            produit.setStock(updatedProduit.getStock());
            return produitRepository.save(produit);
        }).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
