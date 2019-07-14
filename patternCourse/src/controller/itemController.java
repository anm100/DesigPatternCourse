package controller;

import GUI.addInsuranceUI;
import Models.Insurance;

public class itemController {

	addInsuranceUI GUI ;
		
public itemController(addInsuranceUI gUI) {
		super();
		GUI = gUI;
}



public void  addNewProduct(Insurance p){
	p.addItem();
}

}
