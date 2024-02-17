package com.uce.edu.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

    @Override
    public String getID() {
        // TODO Auto-generated method stub
		String cedula="1724362106";
		cedula=cedula+"provincia";
		return cedula;
    }

}
