package com.flexivebackend.Flexive.Controller;

import com.flexivebackend.Flexive.Model.Investment;
import com.flexivebackend.Flexive.Model.User;
import com.flexivebackend.Flexive.Repository.InvestmentRepo;
import com.flexivebackend.Flexive.Service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
@RestController
@RequestMapping("/api/investments")
@CrossOrigin
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;
    private InvestmentRepo investmentRepo;

    @PostMapping("")
    public ResponseEntity<?> createInvestment ( @AuthenticationPrincipal User user){
        Investment newinvestment = investmentService.save(user);
        return ResponseEntity.ok(newinvestment);
    }

    @PutMapping("")
    public ResponseEntity<?> update (@RequestBody Investment investment){
        Investment updatedInvestment = investmentService.update(investment);
        return ResponseEntity.ok(updatedInvestment);
    }

    @GetMapping("")
    public ResponseEntity<?> getInvestments(@AuthenticationPrincipal User user){
        Set<Investment> investmentsByUser = investmentService.findByUser(user);
        return ResponseEntity.ok(investmentsByUser);
    }

    @PatchMapping("")
    public ResponseEntity<?> addToInvestment(@RequestBody Map<String,String> updatedInvestment){
        int id = Integer.parseInt(updatedInvestment.get("id"));

        Investment investment = investmentService.getInvestment(id);

        int oldAmount = investment.getInvested();
        int newAmount = Integer.parseInt(updatedInvestment.get("investment"));

        String operation = updatedInvestment.get("operation");
        int combined;
        if(operation.equals("add")){
            combined = oldAmount + newAmount;
        }
        else{
            combined = oldAmount - newAmount;
            if(combined < 0){
                combined = 0;
            }
        }

        investment.setInvested(combined);

        investmentService.saveFunds(investment);


        return ResponseEntity.ok(investment);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteInvestment(@RequestBody Map<String,String> investment){
        int id = Integer.parseInt(investment.get("id"));

        investmentService.delete(id);

        return ResponseEntity.ok(investment);


    }

}
