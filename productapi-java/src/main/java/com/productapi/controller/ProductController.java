package com.productapi.controller;

import com.productapi.models.Product;
import com.productapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(required = false) Integer companyId,
            @RequestParam(name = "offset") int offset,
            @RequestParam(name = "limit") int limit,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "id") String sortBy) {

        try {
            List<Product> products = productService.findProducts(companyId, offset, limit, sort, sortBy);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @GetMapping("/products")
//    public ResponseEntity<Map<String, Object>> getAllProducts(
//            @RequestParam(required = false) Integer companyId,
//            @RequestParam(defaultValue = "0") int offset,
//            @RequestParam(defaultValue = "3") int limit,
//            @RequestParam(defaultValue = "asc") String sort,
//            @RequestParam(defaultValue = "id") String sortBy)
//    {
//
//        try {
//            List<Product> products = new ArrayList<Product>();
//
//            Sort.Order order = new Sort.Order(Sort.Direction.fromString(sort), sortBy);
////            Pageable pageable = PageRequest.of(offset, limit, Sort.by(order));
//
//            Pageable pageable = new OffsetBasedPageRequest(offset, limit, Sort.by(order));
//
//
//            Page<Product> pageTuts;
//            if (companyId == null)
//                pageTuts = productRepository.findAll(pageable);
//            else
//                pageTuts = productRepository.findByCompanyId(companyId, pageable);
//
//            products = pageTuts.getContent();
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("products", products);
//            response.put("currentPage", pageTuts.getNumber());
//            response.put("totalItems", pageTuts.getTotalElements());
//            response.put("totalPages", pageTuts.getTotalPages());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
