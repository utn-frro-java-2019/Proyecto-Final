package main;

import java.util.ArrayList;

import data.cocheraData;
import domain.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cochera> cocheras = cocheraData.getAll();
		for(Cochera c: cocheras) {
			System.out.println(c.getIdCochera()+" - "+c.getUbicacion()+" - "+c.getDescripcion());		
		}
	}

}
