package hashmap_java;

public class TestMyHashMap {

    public static void main(String[] args) {
        
        Person cosby = new Person("cosby@cosby.dk", "Cosby cosbysen");
        Person cosby2 = new Person("cosby2@cosby2.dk", "Cosby2 Cosby2sen");
        Person mo = new Person("mo@mo.com", "Mr. Mo");

        MyHashMap<String, Person> map = new MyHashMap<>(5);
        map.put(cosby.getEmail(), cosby);
        map.put(cosby2.getEmail(), cosby2);
        map.put(mo.getEmail(), mo);

        Person moGet = map.get("mo@mo.com");

        System.out.println(moGet.getEmail());
        System.out.println(moGet.getName());

        int hash1 = "cosby@cosby.com".hashCode();
        int hash2 = "mo@mo.com".hashCode();

        int modHash1 = MyHashMap.mod(hash1, 5);
        int modHash2 = MyHashMap.mod(hash2, 5);

        System.out.printf("%d - %d%n", hash1, modHash1);
        


    }

    private static class Person {
        private String email;
        private String name;

        public Person(String email, String name){
            this.email = email;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }
    
}
