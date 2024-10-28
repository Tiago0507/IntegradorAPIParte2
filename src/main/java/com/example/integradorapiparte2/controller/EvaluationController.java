package com.example.integradorapiparte2.controller;

import com.example.integradorapiparte2.entity.Evaluation;
import com.example.integradorapiparte2.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(maxAge = 3600)
public class EvaluationController {

    @Autowired
    private EvaluationRepository evaluationRepository;

    // El navegador pide la muestra para graficarla
    @GetMapping("evaluation/{id}")
    public ResponseEntity<?> getEvaluationById(@PathVariable("id") long id) {
        var evaluation = evaluationRepository.findById(id);
        if(evaluation.isPresent()) {
            return ResponseEntity.status(200).body(evaluation.get());
        }else {
            var response = new HashMap<String, String>();
            response.put("message", "La muestra no se encontró");
            return ResponseEntity.status(404).body(response);
        }
    }

    // El controlador envía datos a este endopoing
    @PostMapping("evaluation")
    public ResponseEntity<?> addEvaluation(@RequestBody Evaluation evaluation) {
        evaluationRepository.save(evaluation);

        var response = new HashMap<String, String>();
        response.put("message", "Operacion realizada");
        return ResponseEntity.status(200).body("Done");
    }
}
