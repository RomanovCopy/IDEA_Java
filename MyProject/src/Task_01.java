


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

    private StringBuilder sub = new StringBuilder("select * from students WHERE ");
    private String test = "{name:Ivanov,country:Russia,city:Moscow,age:null}";

    public Task_01() {

        System.out.println(sub.append(jsonParse(test)).toString());
    }

    /**
     * преобразование строки JSON файла в строку требуемого запроса
     * 
     * @param json строка JSON файла
     * @return строка для добавления к запросу
     */
    private String jsonParse(String json) {
        var sb = new StringBuilder("");
        // разбиваем на ячейки
        var items = json.split("[, ]");
        // перебираем полученные ячейки
        for (String subItem : items) {
            // если ячейка существует и состоит из
            // двух элементов, то вставляем их в
            // строку запроса
            if (subItem != null) {
                var sub=subItem.replaceAll("[{}]","");
                var d = sub.split("[:]");
                if (d.length == 2 && d[0] != null && d[1] != null && !d[1].equals("null")) {
                    sb.append(d[0] + "=").append(d[1] + " AND ");
                }
            }
        }
        // финальная строка не должна содержать в конце
        // суффикс "AND"
        if (sb.toString().endsWith(" AND ")) {
            sb.delete(sb.length() - 5, sb.length());
        }
        return sb.toString();
    }

}
