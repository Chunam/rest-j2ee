package org.phuong.services;

import java.util.ArrayList;
import java.util.List;

import org.phuong.model.SimpleObject;

public class HeroesServiceMock {

	public static final HeroesServiceMock _instance = new HeroesServiceMock();
	private List<SimpleObject> heroes;
	
	public HeroesServiceMock(){
		heroes = new ArrayList<SimpleObject>();
		heroes.add(new SimpleObject(heroes.size(), "Mr. Nice"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. Narco"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. Bombasto"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. Celeritas"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. Magneta"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. RubberMan"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. Dynama"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. Dr IQ"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. Magma"));
		heroes.add(new SimpleObject(heroes.size(), "Mr. Tornado"));
	}
	
	public List<SimpleObject>  getHeroes() {
		return heroes;
	}

	public SimpleObject getHero(int index) {
		return heroes.get(index);
	}
	
}
