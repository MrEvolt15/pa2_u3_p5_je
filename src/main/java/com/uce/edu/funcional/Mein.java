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

        //3. Predicate
        System.out.println("**********************************PREDICATE");
        //Lambdas
        System.out.println("Impl Lambdas");
        IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7)==0;
        System.out.println(predicateLambda.evaluate(8));
        IPersonaPredicate<String> predicateLambda2 = letra -> "Joel".contains(letra);
        System.out.println(predicateLambda2.evaluate("o"));
    }
}
