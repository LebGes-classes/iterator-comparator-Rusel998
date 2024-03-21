package HashMap;

public class Main {
    public static void main(String[] args) {
        CustomHashmap<String, Integer> hashmap = new CustomHashmap<>();

        hashmap.put("Крутой чел", 1);
        hashmap.put("Не-не, такого не было", 2);
        hashmap.put("У У У У У", 3);

        System.out.println("Size: " + hashmap.size());
        System.out.println("Значение ключа 'У У У У У': " + hashmap.get("У У У У У"));
        System.out.println("Значение ключа 'А ок': " + hashmap.get("А ок"));

        System.out.println("Содержит ключ 'Не-не, такого не было': " + hashmap.containsKey("Не-не, такого не было"));
        System.out.println("Содержит значение 3: " + hashmap.containsValue(2));

        System.out.println("Удаляем ключ 'У У У У У': ");
        hashmap.remove("У У У У У");
        System.out.println("Размер после удаления: " + hashmap.size());

        System.out.println(hashmap.hasNext());
        System.out.println(hashmap.next());
//Сравниваем два размера двух хэшмапов
        CustomHashmap<String, Integer> hashmap2 = new CustomHashmap<>();

        hashmap2.put("ya ya", 4);

        System.out.println(hashmap.compareTo(hashmap2));

        Comparator<CustomHashmap<String, Integer>> c = new Comparator<>();

        System.out.println(c.compare(hashmap, hashmap2));

        System.out.println(hashmap.hashCode() + " " +  hashmap2.hashCode());
    }
}