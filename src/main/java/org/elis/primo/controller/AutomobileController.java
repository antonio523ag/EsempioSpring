//package org.elis.primo.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.elis.primo.db.SingletonDb;
//import org.elis.primo.model.Automobile;
//import org.elis.primo.service.def.AutomobileService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/automobile")
//@RequiredArgsConstructor
//public class AutomobileController {
//
//    //@Autowired
//    private final AutomobileService service;
//
////    public AutomobileController(AutomobileService service) {
////        this.service = service;
////    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Long> creaAutomobile(@RequestBody Automobile automobile){
//        if(automobile==null||
//                automobile.getTarga()==null||
//                automobile.getTarga().length()!=7){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        long idAuto= SingletonDb.getInstance()
//                .aggiungiAutomobile(automobile);
//        if(idAuto==0){
//            return ResponseEntity.
//                    status(HttpStatus.CONFLICT)
//                    .build();
//            //.body(1);
//        }
//        return ResponseEntity.ok(idAuto);//.build()
//    }
//
//    @PostMapping("/add/bulk")
//    public ResponseEntity<List<Long>> aggiungiInBulk
//            (@RequestBody List<Automobile> automobili){
//        List<Long> ids=new ArrayList<>();
//        for(Automobile a:automobili){
//            if(a.getTarga()==null||
//                    a.getTarga().length()!=7){
//                return new ResponseEntity<>
//                        (HttpStatus.BAD_REQUEST);
//            }
//            long id=SingletonDb.getInstance()
//                    .aggiungiAutomobile(a);
//            if(id==0){
//                return ResponseEntity.badRequest().build();
//            }
//            ids.add(id);
//        }
//        return ResponseEntity.ok(ids);
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Automobile>> getAll(){
//        return new ResponseEntity<>(SingletonDb.getInstance()
//                .getAutomobili(),HttpStatus.OK);
//    }
//
//
//}

package org.elis.primo.controller;

import lombok.RequiredArgsConstructor;
import org.elis.primo.db.SingletonDb;
import org.elis.primo.model.Automobile;
import org.elis.primo.service.def.AutomobileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/automobile")
@RequiredArgsConstructor
public class AutomobileController {

    //@Autowired
    private final AutomobileService service;

//    public AutomobileController(AutomobileService service) {
//        this.service = service;
//    }

    @PostMapping("/add")
    public ResponseEntity<Long> creaAutomobile(@RequestBody Automobile automobile){
        long id=service.creaAutomobile(automobile);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Automobile>> getAll(){
        List<Automobile> automobili=service.getAll();
        return new ResponseEntity<>
                (automobili, HttpStatus.OK);
    }


}

