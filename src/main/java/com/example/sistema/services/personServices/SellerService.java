package com.example.sistema.services.personServices;

import com.example.sistema.models.personModels.Employee;
import com.example.sistema.models.personModels.Seller;
import com.example.sistema.repositories.personRepositories.SellerRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional
    public Seller create(Seller seller) {
        seller.setId(null);
        return sellerRepository.save(seller);
    }

    public Seller findById(Long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        return seller.orElseThrow(() -> new ObjectNotFoundException(
                "Vendedor não encontrado! id: " + id + ", Tipo: " + Seller.class.getName()
        ));
    }

    public List<Seller> findAllSellers() {
        return sellerRepository.findAll();
    }
    
    @Transactional
    public Seller update(Seller sellerObj) {
        Seller seller = findById(sellerObj.getId());

        sellerObj.setId(seller.getId());
        sellerObj.setName(seller.getName());
//        sellerObj.setHiringDate(seller.getHiringDate());
        sellerObj.setCpf(seller.getCpf());
        sellerObj.setEmail(seller.getEmail());
        sellerObj.setNationality(seller.getNationality());
        return sellerRepository.save(sellerObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            sellerRepository.deleteById(id);
        } catch(Exception ex) {
            throw new DataBidingViolationException("Não a possivel excluir pois há entidades relacionadas");
        }
    }
}

