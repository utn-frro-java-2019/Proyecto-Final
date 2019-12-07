package business;
import java.util.ArrayList;
import data.CocheraData;
import domain.*;

public class CocheraController {
	
	public static ArrayList<Cochera> getAll(){
		return new CocheraData().getAll();
	}

	public static Cochera getOne(int idCochera){
		return new CocheraData().getOne(idCochera);
	}
	
	public static void deleteOne(int idCochera){
		new CocheraData().deleteOne(idCochera);
	}

}
