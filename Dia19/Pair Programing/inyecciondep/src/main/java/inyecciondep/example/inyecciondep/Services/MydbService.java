package inyecciondep.example.inyecciondep.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import inyecciondep.example.inyecciondep.Models.CosaModel;

@Service
public class MydbService implements GreatService {

    @Override
    public ArrayList<CosaModel> ObtainCosas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CosaModel ObtainCosa(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void UpdateCosa(int id, CosaModel cosa) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void DeleteCosa(int id) {
        // TODO Auto-generated method stub
        
    }

}
