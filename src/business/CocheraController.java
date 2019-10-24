package business;
import java.util.ArrayList;
import data.CocheraData;
import domain.*;

public class CocheraController {
	
	CocheraData coData;
	
	public CocheraController() {
		coData = new CocheraData();	
	}
	
	public ArrayList<Cochera> getAll(){
		//return coData.getAll();
		return CocheraData.getAll();
	}

	public Cochera getOne(int idCochera){
		//return coData.getOne(idCochera);
		return CocheraData.getOne(idCochera);
	}

}
