import java.io.*;
import java.util.*;
  
class GFG {
    final static String filePath
        = "leader.txt";
    public static void main(String[] args)
    {
  
        // fails par hasmapu
        Map<String, String> mapFromFile
            = HashMapFromTextFile();
  
        // parskata failu
        for (Map.Entry<String, String> entry :
             mapFromFile.entrySet()) {
            System.out.println(entry.getKey() + "-"
                               + entry.getValue());
        }
    }
  
    public static Map<String, String> HashMapFromTextFile()
    {
  
        Map<String, String> map
            = new HashMap<String, String>();
        BufferedReader br = null;
  
        try {
  
            // parveido par objektu
            File file = new File(filePath);
  
        
            br = new BufferedReader(new FileReader(file));
  
            String line = null;
  
            // lasa pa linijam
            while ((line = br.readLine()) != null) {

                String[] parts = line.split("-");
  
                // sadala pa vardu un numuru
                String name = parts[0].trim();
                String number = parts[1].trim();
  
                // vardu un numuru ievietu hasmap
                if (!name.equals("") && !number.equals(""))
                    map.put(name, number);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            // aizver readeri
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        
        map=sortByValue(map);

        return map;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}