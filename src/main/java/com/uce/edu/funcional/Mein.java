package com.uce.edu.funcional;

public class Mein {
    public static void main(String[] args) {
        // 1.Supplier
        System.out.println("**********************************SUPPLIER");
        // Clases
        System.out.println("Impl Clases");
        IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
        System.out.println(supplierClase.getID());
        // Lambdas
        System.out.println("Impl Lambda");
        IPersonaSupplier<String> supplierLambda = () -> {
            String cedula = "624829584";
            cedula = cedula + "canton";
            return cedula;
        };
        System.out.println(supplierLambda.getID());

        System.out.println("Impl Lambda2");
        IPersonaSupplier<String> supplierLambda2 = () -> "624829584" + "pais";
        System.out.println(supplierLambda2.getID());

        System.out.println("Impl Lambda3");
        IPersonaSupplier<Integer> supplierLambda3 = () -> {
            Integer valor1  = Integer.valueOf(100);
            valor1 =valor1 * Integer.valueOf(50)/Integer.valueOf(5);
            return valor1;  
        };
        System.out.println(supplierLambda3.getID());
        //Metodos Referenciados
        System.out.println("Impl Metodo Referenciado");
        MetodosReferenciados met = new MetodosReferenciados();
        IPersonaSupplier<String> supplierLambda4 = met::getID;
        System.out.println(supplierLambda4.getID());;

        //2. Comsummer
        System.out.println("**********************************CONSUMER");
        //Clases
        System.out.println("Impl Clases");
        IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
        consumerClase.accept("Profesor");
        //Lambdas
        System.out.println("Impl Lambdas");
        IPersonaConsumer<String> consumerLambda = cadena -> {
            System.out.println("Se inserta");
            System.out.println(cadena);
        };
        consumerLambda.accept("Profesor");
        //Metodos Referenciados
        System.out.println("Impl Metodo Referenciado");
        IPersonaConsumer<String> consumerLambda2= met::procesar;
        consumerLambda2.accept("Joel Referenciado");

        //3. Predicate
        System.out.println("**********************************PREDICATE");
        //Lambdas
        System.out.println("Impl Lambdas");
        IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)==0;
        System.out.println(predicateLambda.evaluate(8));
        IPersonaPredicate<String> predicateLambda2 = letra -> "Joel".contains(letra);
        System.out.println(predicateLambda2.evaluate("o"));
        //Metodos Referenciados
        System.out.println("Impl Metodo Referenciado");
        IPersonaPredicate<String> predicateLambda3 = met::evaluar;
        System.out.println(predicateLambda3.evaluate("k"));
        IPersonaPredicate<Integer> predicateLambda4 = met::evaluar;
        System.err.println(predicateLambda4.evaluate(8));

        //4. FUNCTION
        System.out.println("**********************************FUNCTION");
        //Lambdas
        System.out.println("Impl Lambdas");
        IPersonaFunction<String, Integer> functionLambda = numero ->{
            numero = numero + Integer.valueOf(10);
            String numString = numero.toString().concat("-Valor");
            return numString;
        };
        System.out.println(functionLambda.aplicar(7));
        IPersonaFunction<Empleado,Ciudadano> functionLambda1 = ciudadano ->{
            Empleado empl = new Empleado();
            empl.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getApellido());
            if(ciudadano.getProvincia().compareTo("Pichincha")==0){
                empl.setPais("Ecuador");
            }
            return empl;
        };
        Ciudadano ciu = new Ciudadano();
        ciu.setApellido("Espinosa");
        ciu.setNombre("Joel");
        ciu.setProvincia("Pichincha");
        System.out.println(functionLambda1.aplicar(ciu)); 
        //Metodos Referenciados
        System.out.println("Impl Metodo Referenciado");
        IPersonaFunction<Ciudadano,Empleado> function2 = met::cambiar;
        Empleado e = new Empleado();
        e.setNombreCompleto("Juan Perez");
        e.setPais("Ecuador");
        System.out.println(function2.aplicar(e));

        //4. UNARY OPERATOR
        System.out.println("**********************************UNARY OPERATOR");
        //Lambdas
        System.out.println("Impl Lambdas");
        IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero +(numero*2);
        System.out.println(unaryOperatorLambda.aplicar(14));
        IPersonaUnaryOperatorFunction<Integer> unaryOperatorFunctionLambda = numero -> numero +(numero*2);
        System.out.println(unaryOperatorFunctionLambda.aplicar(14));
        //Metodos Referenciados
        System.out.println("Impl Metodo Referenciado");
        IPersonaUnaryOperatorFunction<Empleado> unaryOperator1 = met::procesar;
        Empleado empl3 = unaryOperator1.aplicar(e);
        System.out.println(empl3);
    }
}
