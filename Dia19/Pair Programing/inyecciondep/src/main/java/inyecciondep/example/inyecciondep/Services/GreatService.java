package inyecciondep.example.inyecciondep.Services;
import java.util.ArrayList;

import inyecciondep.example.inyecciondep.Models.CosaModel;

public interface GreatService {

    public ArrayList<CosaModel> ObtainCosas();
    public CosaModel ObtainCosa(int id);
    public void UpdateCosa(int id, CosaModel cosa);
    public void DeleteCosa(int id);
    
}
