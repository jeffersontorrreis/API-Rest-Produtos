package com.shopify.virtual.services;

import com.shopify.virtual.dto.ProductDTO;
import com.shopify.virtual.entities.Product;
import com.shopify.virtual.repositories.ProductRepository;
import com.shopify.virtual.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> list = repository.findAll(pageable);
        return list.map(x -> new ProductDTO(x.getId(), x.getName(), x.getDescription(), x.getPrice(), x.getStock(), x.getCategory()));
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){

            Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
            return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getCategory());

    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setStock(dto.getStock());
        entity.setCategory(dto.getCategory());

        entity = repository.save(entity);

        return new ProductDTO(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getStock(), entity.getCategory());
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){

            Product entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setPrice(dto.getPrice());
            entity.setStock(dto.getStock());
            entity.setCategory(dto.getCategory());

            entity = repository.save(entity);

            return new ProductDTO(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getStock(), entity.getCategory());

    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        repository.deleteById(id);

    }

}
