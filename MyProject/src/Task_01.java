import netscape.javascript.JSObject;


public class Task_01 {

    /*
     * Дана строка sql-запроса "select * from students WHERE ".
     * Сформируйте часть WHERE этого запроса, используя StringBuilder.
     * Данные для фильтрации приведены ниже в виде json-строки.
     * Если значение null, то параметр не должен попадать в запрос.
     * String input_str =
     * "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
     * Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow",
     * "age":"null"}
     * вывод: select * from students WHERE name=Ivanov AND country=Russia AND
     * city=Moscow
     */

     String input_str = "{name:Ivanov,country:Russia,city:Moscow,age:null}";

    public Task_01() {
        StringBuilder sb = new StringBuilder("select * from students WHERE ");
        JSObject input = new JSObject(input_str);
        String name = input.optString("name");
        String country = input.optString("country");
        String city = input.optString("city");
        String age = input.optString("age");

        if (name != null) {
            sb.append("name=").append(name).append(" AND ");
        }
        if (country != null) {
            sb.append("country=").append(country).append(" AND ");
        }
        if (city != null) {
            sb.append("city=").append(city).append(" AND ");
        }
        if (age != null && !age.equals("null")) {
            sb.append("age=").append(age).append(" AND ");
        }

        // remove the last "AND"
        if (sb.toString().endsWith("AND ")) {
            sb.delete(sb.length() - 5, sb.length());
        }

        String sqlQuery = sb.toString(); // select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow.

    }

    private String 

}
