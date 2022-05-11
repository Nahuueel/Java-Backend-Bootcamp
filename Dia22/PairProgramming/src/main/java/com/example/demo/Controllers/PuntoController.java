package com.example.demo.Controllers;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.Model.Punto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

@Controller
public class PuntoController {
    
    @GetMapping()
    public String main(Model model){
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8080/puntos").asJson();
        List<Punto> l = new LinkedList<Punto>();
        
        for(int i=0;i<response.getBody().getArray().length();i++){
            JSONObject j = response.getBody().getArray().getJSONObject(i);
            l.add(new Punto(j.getInt("x")*10+250, -j.getInt("y")*10+250));
        }
        
        model.addAttribute("newPunto",new Punto());
        model.addAttribute("Punto", l);
        return "css";
    }

    @PostMapping("/post")
    public String addPunto(Punto punto){
        // Map<String, String> headers = new HashMap<>();
        // headers.put("accept", "application/json");
        // Map<String, Object> fields = new HashMap<String, Object>();
        // fields.put("x", punto.getX());
        // fields.put("y",punto.getY());
        JSONObject j = new JSONObject(punto);
        System.out.println(j);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8080/puntos/"+String.valueOf(punto.getX())+"/"+String.valueOf(punto.getY())).asJson();
        return "redirect:/";
    }
}
