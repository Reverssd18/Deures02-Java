package com.exercicis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Exercici0202 {

    public static Scanner scanner;
    public static Locale defaultLocale;
    
    // ./run.sh com.exercicis.Exercici0202
    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);

        //showJSONAstronautes("./data/astronautes.json");

        //showEsportistesOrdenatsPerMedalla("./data/esportistes.json", "or");
        //showEsportistesOrdenatsPerMedalla("./data/esportistes.json", "plata");

        mostrarPlanetesOrdenats("./data/planetes.json", "nom");
        mostrarPlanetesOrdenats("./data/planetes.json", "radi");
        mostrarPlanetesOrdenats("./data/planetes.json", "massa");
        mostrarPlanetesOrdenats("./data/planetes.json", "distància");
        // JSONPlanetesToArrayList("./data/planetes.json");

       /*
        ArrayList<HashMap<String, Object>> dades = new ArrayList<>();

        ArrayList<String> caracteristiquesPacific = new ArrayList<>();
        caracteristiquesPacific.add("És l'oceà més gran del món");
        caracteristiquesPacific.add("Conté la fossa de les Marianes, la més profunda del món");
        caracteristiquesPacific.add("Conté una illa de plàstics contaminants.");

        ArrayList<String> caracteristiquesAtlantic = new ArrayList<>();
        caracteristiquesAtlantic.add("Separa Amèrica d'Europa i Àfrica");
        caracteristiquesAtlantic.add("Conté el famós Triangle de les Bermudes");

        ArrayList<String> caracteristiquesMediterrani = new ArrayList<>();
        caracteristiquesMediterrani.add("És un mar gairebé tancat");
        caracteristiquesMediterrani.add("Connecta amb l'oceà Atlàntic a través de l'estret de Gibraltar");

        dades.add(crearMassaAigua("Oceà Pacífic", "oceà", 168723000, 10924, caracteristiquesPacific));
        dades.add(crearMassaAigua("Oceà Atlàntic", "oceà", 85133000, 8486, caracteristiquesAtlantic));
        dades.add(crearMassaAigua("Oceà Índic", "oceà", 70560000, 7450, new ArrayList<>()));
        dades.add(crearMassaAigua("Oceà Àrtic", "oceà", 15558000, 5450, new ArrayList<>()));
        dades.add(crearMassaAigua("Mar Mediterrani", "mar", 2500000, 5121, caracteristiquesMediterrani));
        dades.add(crearMassaAigua("Mar Carib", "mar", 2754000, 7686, new ArrayList<>()));
        dades.add(crearMassaAigua("Mar de la Xina Meridional", "mar", 3500000, 5560, new ArrayList<>()));

        
        

        try {
            generarJSON(dades, "./data/aigua.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(JSONEsportistesToArrayList("./data/esportistes.json"));
        */
        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Llegeix l'arxiu de 'filePath' i mostra per consola les dades dels astronautes.
     * 
     * El format és:
     * > Astronauta 0:
     *   Nom: Yuri Gagarin
     *   Naixement: 1934
     * > Astronauta 1:
     *   Nom: Neil Armstrong
     *   Naixement: 1930
          * @throws IOException 
          * 
          * @test ./runTest.sh com.exercicis.TestExercici0202#testShowJSONAstronautes
          */
         public static void showJSONAstronautes(String filePath) throws IOException {
       
    
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jSONObject = new JSONObject(content); //Passar a objecte
        JSONArray jSONArray = jSONObject.getJSONArray("astronautes"); //Passar a array
        
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject astronauta = jSONArray.getJSONObject(i);
            System.out.println("> Astronauta " + i + ":");
            System.out.println("  Nom: " + astronauta.getString("nom"));
            System.out.println("  Naixement: " + astronauta.getInt("any_naixement"));
        }       
    
    
    
    } 

    /**
     * Llegeix l'arxiu de 'filePath', retorna un ArrayList amb les dades dels astronautes
     * Les dades han d'estar en un HashMap amb les claus "nom" i "any_naixement"
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testJSONAstronautesToArrayList
     */
    public static ArrayList<HashMap<String, Object>> JSONAstronautesToArrayList(String filePath) {
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jSONObject = new JSONObject(content); //Passar a objecte
            JSONArray jSONArray = jSONObject.getJSONArray("astronautes"); //Passar a array

            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject astronauta = jSONArray.getJSONObject(i);
                HashMap<String, Object> astronautaHM = new HashMap<>(); 
                astronautaHM.put("nom", astronauta.getString("nom"));
                astronautaHM.put("any_naixement", astronauta.getInt("any_naixement"));
                rst.add(astronautaHM);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rst;
    }

    /**
     * Llegeix l'arxiu de 'filePath', retorna un ArrayList amb les dades dels esportistes
     * Les dades han d'estar en un HashMap amb: nom, any_naixement, pais i medalles
     * Les medalles de la clau 'medalles' han d'estar en un HashMap amb les claus "or", "plata" i "bronze"
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testJSONEsportistesToArrayList
     */
    public static ArrayList<HashMap<String, Object>> JSONEsportistesToArrayList(String filePath) {
        ArrayList<HashMap<String, Object>> rst = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jSONArray = new JSONArray(content); 
            

            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject esportista = jSONArray.getJSONObject(i);
                HashMap<String, Object> esportistaMap = new HashMap<>();
                esportistaMap.put("nom", esportista.getString("nom"));
                esportistaMap.put("any_naixement", esportista.getInt("any_naixement"));
                esportistaMap.put("pais", esportista.getString("pais"));
                esportistaMap.put("medalles", esportista.getJSONObject("medalles_olimpiques").toMap());

                rst.add(esportistaMap);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rst;
    }

    /**
     * Llegeix l'arxiu JSON i retorna una llista d'esportistes ordenada per una medalla específica (or, plata o bronze).
     *
     * Si el tipus no és "or", "plata" o "bronze" llança una excepció IllegalArgumentException. Amb el text:
     * "Tipus de medalla invàlid: {tipusMedalla}. Tipus vàlids: 'or', 'plata' o 'bronze'."
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels esportistes.
     * @param tipusMedalla Tipus de medalla per ordenar: "or", "plata" o "bronze".
     * @return Llista ordenada d'esportistes segons el nombre de medalles especificat.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testOrdenarEsportistesPerMedalla
     */
    public static ArrayList<HashMap<String, Object>> ordenarEsportistesPerMedalla(String filePath, String tipusMedalla) {
        // Obtenir la llista d'esportistes des del fitxer JSON
        ArrayList<HashMap<String, Object>> esportistes = JSONEsportistesToArrayList(filePath);

        // Validar el tipus de medalla
        if (!tipusMedalla.equals("or") && !tipusMedalla.equals("plata") && !tipusMedalla.equals("bronze")) {
            throw new IllegalArgumentException("Tipus de medalla invàlid: " + tipusMedalla + ". Tipus vàlids: 'or', 'plata' o 'bronze'.");
        }

        // Ordenar els esportistes segons el tipus de medalla
        esportistes.sort((esportista1, esportista2) -> {
            HashMap<String, Integer> medalles1 = (HashMap<String, Integer>) esportista1.get("medalles");
            HashMap<String, Integer> medalles2 = (HashMap<String, Integer>) esportista2.get("medalles");
            return medalles2.get(tipusMedalla).compareTo(medalles1.get(tipusMedalla));
        });

        return esportistes;
    }

    /**
     * Mostra una taula amb els esportistes ordenats per una medalla específica (or, plata o bronze).
     *
     * Les paraules "or", "plata" i "bronze" han de ser mostrades amb la 
     * primera lletra en majúscules i la resta en minúscules.
     * 
     * El format de la taula ha de fer servir els caràcters: "┌", "┬", "┐", "├", "┼", "┤", "└", "┴" i "┘".
     * 
     * Un exemple simplificat de la taula seria:
     * ┌──────────────────────┬─────────────────┬────────────┬────────┐
     * │ Nom                  │ País            │ Naixement  │ Plata  │
     * ├──────────────────────┼─────────────────┼────────────┼────────┤
     * │ Larisa Latynina      │ Unió Soviètica  │ 1934       │ 5      │
     * │ Michael Phelps       │ Estats Units    │ 1985       │ 3      │
     * └──────────────────────┴─────────────────┴────────────┴────────┘
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels esportistes.
     * @param tipusMedalla Tipus de medalla per ordenar: "or", "plata" o "bronze".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerOr
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerPlata
     * @test ./runTest.sh com.exercicis.TestExercici0202#testShowEsportistesOrdenatsPerBronze
     */
    public static void showEsportistesOrdenatsPerMedalla(String filePath, String tipusMedalla) {
        ArrayList<HashMap<String, Object>> esportistes = ordenarEsportistesPerMedalla(filePath, tipusMedalla);

        String tipusMedallaCapitalized = tipusMedalla.substring(0, 1).toUpperCase() + tipusMedalla.substring(1).toLowerCase();

        String[] headers = {"Nom", "País", "Naixement", tipusMedallaCapitalized};
        int[] columnWidths = {20, 15, 10, 6};

        StringBuilder rst = new StringBuilder();

        rst.append("┌");
        for (int i = 0; i < headers.length; i++) {
            rst.append("─".repeat(columnWidths[i]+2));
            if (i < headers.length - 1) {
                rst.append("┬");
            }
        }
        rst.append("┐\n");

        rst.append("│");
        for (int i = 0; i < headers.length; i++) {
            rst.append(String.format(" %-"+columnWidths[i]+"s │", headers[i]));
        }
        rst.append("\n");

        rst.append("├");
        for (int i = 0; i < headers.length; i++) {
            rst.append("─".repeat(columnWidths[i]+2));
            if (i < headers.length - 1) {
                rst.append("┼");
            }
        }
        rst.append("┤\n");

        for (HashMap<String, Object> esportista : esportistes) {
            HashMap<String, Integer> medalles = (HashMap<String, Integer>) esportista.get("medalles");
            rst.append("│");
            rst.append(String.format(" %-"+columnWidths[0]+"s │", esportista.get("nom")));
            rst.append(String.format(" %-"+columnWidths[1]+"s │", esportista.get("pais")));
            rst.append(String.format(" %-"+columnWidths[2]+"d │", esportista.get("any_naixement")));
            rst.append(String.format(" %-"+columnWidths[3]+"d │", medalles.get(tipusMedalla)));
            rst.append("\n");
        }

        rst.append("└");
        for (int i = 0; i < headers.length; i++) {
            rst.append("─".repeat(columnWidths[i] + 2));
            if (i < headers.length - 1) {
                rst.append("┴");
            } 
            if (i == headers.length - 1) {  
                rst.append("┘");
            }
        }
        rst.append("\n");

        System.out.print(rst);
    }

    /**
     * Llegeix l'arxiu JSON i converteix la informació dels planetes en una llista d'objectes HashMap.
     * 
     * Cada planeta es representa com un HashMap amb les claus:
     * - "nom" -> String amb el nom del planeta.
     * - "dades_fisiques" -> HashMap amb:
     *     - "radi_km" -> Double amb el radi en quilòmetres.
     *     - "massa_kg" -> Double amb la massa en kilograms.
     * - "orbita" -> HashMap amb:
     *     - "distancia_mitjana_km" -> Double amb la distància mitjana al Sol en quilòmetres.
     *     - "periode_orbital_dies" -> Double amb el període orbital en dies.
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels planetes.
     * @return Una ArrayList de HashMap amb la informació dels planetes.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testJSONPlanetesToArrayList
     */
    public static ArrayList<HashMap<String, Object>> JSONPlanetesToArrayList(String filePath) throws IOException{
        ArrayList<HashMap<String, Object>> planetesList = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray = jsonObject.getJSONArray("planetes");

            for (int i = 0; i < jsonArray.length(); i++) {
                HashMap<String, Object> planet = new HashMap<>();
                JSONObject planeta = jsonArray.getJSONObject(i);
                String nom = planeta.getString("nom");

                JSONObject dades = planeta.getJSONObject("dades_fisiques");
                HashMap<String,Double> dades_fisiques = new HashMap<>();
                Double radi_km = dades.getDouble("radi_km");
                Double massa_kg = dades.getDouble("massa_kg");
                dades_fisiques.put("radi_km", radi_km);
                dades_fisiques.put("massa_kg", massa_kg);

                JSONObject orb = planeta.getJSONObject("orbita");
                HashMap<String,Object> orbita = new HashMap<>();
                Integer distancia_mitjana_km = orb.getInt("distancia_mitjana_km");
                Double periode_orbital_dies = orb.getDouble("periode_orbital_dies");
                orbita.put("distancia_mitjana_km", distancia_mitjana_km);
                orbita.put("periode_orbital_dies", periode_orbital_dies);

                planet.put("nom", nom);
                planet.put("dades_fisiques", dades_fisiques);
                planet.put("orbita", orbita);

                planetesList.add(planet);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planetesList;
    }

    /**
     * Mostra una taula amb els planetes ordenats segons una columna especificada.
     * 
     * Els valors vàlids per a la columna d'ordenació són:
     * - "nom" -> Ordena alfabèticament pel nom del planeta.
     * - "radi" -> Ordena numèricament pel radi del planeta.
     * - "massa" -> Ordena numèricament per la massa del planeta.
     * - "distància" -> Ordena numèricament per la distància mitjana al Sol.
     * 
     * El format de la taula ha de fer servir els caràcters: "┌", "┬", "┐", "├", "┼", "┤", "└", "┴" i "┘".
     * 
     * Ex.:
     * ┌──────────────┬────────────┬──────────────┬────────────────┐
     * │ Nom          │ Radi (km)  │ Massa (kg)   │ Distància (km) │
     * ├──────────────┼────────────┼──────────────┼────────────────┤
     * │ Mercuri      │ 2439.7     │ 3.3011e23    │ 57910000       │
     * │ Venus        │ 6051.8     │ 4.8675e24    │ 108200000      │
     * └──────────────┴────────────┴──────────────┴────────────────┘
     * 
     * @param filePath Ruta de l'arxiu JSON amb les dades dels planetes.
     * @param columnaOrdenacio La columna per la qual es vol ordenar ("nom", "radi", "massa", "distància").
          * @throws IOException 
          * 
          * @throws IllegalArgumentException si el paràmetre de columna és invàlid.
          * 
          * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsNom
          * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsRadi
          * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsMassa
          * @test ./runTest.sh com.exercicis.TestExercici0202#testMostrarPlanetesOrdenatsDistancia
          */
        public static void mostrarPlanetesOrdenats(String filePath, String columnaOrdenacio) throws IOException {
        ArrayList<HashMap<String, Object>> planetes = JSONPlanetesToArrayList(filePath);
        


        String[] headers = {"Nom", "Radi (km)", "Massa (kg)", "Distància (km)"};
        int[] columnWidths = {20, 15, 15, 15};

        StringBuilder rst = new StringBuilder();

        rst.append("┌");
        for (int i = 0; i < headers.length; i++) {
            rst.append("─".repeat(columnWidths[i]+2));
            if (i < headers.length - 1) {
                rst.append("┬");
            }
        }
        rst.append("┐\n");

        rst.append("│");
        for (int i = 0; i < headers.length; i++) {
            rst.append(String.format(" %-"+columnWidths[i]+"s │", headers[i]));
        }
        rst.append("\n");

        rst.append("├");
        for (int i = 0; i < headers.length; i++) {
            rst.append("─".repeat(columnWidths[i]+2));
            if (i < headers.length - 1) {
                rst.append("┼");
            }
        }
        rst.append("┤\n");

        switch (columnaOrdenacio.toLowerCase().trim()) {
            case "nom" -> {
            System.out.println("Ordenat per nom: ");
            planetes.sort((planeta1, planeta2) -> ((String) planeta1.get("nom")).compareTo((String) planeta2.get("nom")));
            }
            case "radi" -> {
            System.out.println("Ordenat per radi: ");
            planetes.sort((planeta1, planeta2) -> {
                HashMap<String, Object> dades1 = (HashMap<String, Object>) planeta1.get("dades_fisiques");
                HashMap<String, Object> dades2 = (HashMap<String, Object>) planeta2.get("dades_fisiques");
                Double a = (Double) dades1.get("radi_km");
                Double b = (Double) dades2.get("radi_km");
                return  a.compareTo(b);
            });
            }
            case "massa" -> {
            System.out.println("Ordenat per massa: ");
            planetes.sort((planeta1, planeta2) -> {
                HashMap<String, Object> dades1 = (HashMap<String, Object>) planeta1.get("dades_fisiques");
                HashMap<String, Object> dades2 = (HashMap<String, Object>) planeta2.get("dades_fisiques");
                Double a = (Double) dades1.get("massa_kg");
                Double b = (Double) dades2.get("massa_kg");
                return  a.compareTo(b);
            });
            }
            case "distància" -> {
            System.out.println("Ordenat per distància: ");
            planetes.sort((planeta1, planeta2) -> {
                HashMap<String, Object> orbita1 = (HashMap<String, Object>) planeta1.get("orbita");
                HashMap<String, Object> orbita2 = (HashMap<String, Object>) planeta2.get("orbita");
                Integer a = (Integer) orbita1.get("distancia_mitjana_km");
                Integer b = (Integer) orbita2.get("distancia_mitjana_km");
                return  a.compareTo(b);
            });
            }
            default -> throw new IllegalArgumentException("Columna d'ordenació invàlida: " + columnaOrdenacio);
        }

        for (HashMap<String, Object> planeta : planetes) {
            HashMap<String, Object> dades_fisiquesMap = (HashMap<String, Object>) planeta.get("dades_fisiques");
            HashMap<String, Object> orbitaMap = (HashMap<String, Object>) planeta.get("orbita");

            rst.append("│");
            rst.append(String.format(" %-"+columnWidths[0]+"s │", planeta.get("nom")));
            rst.append(String.format(" %-"+columnWidths[1]+"s │", dades_fisiquesMap.get("radi_km")));
            rst.append(String.format(" %-"+columnWidths[2]+"s │", (Double) dades_fisiquesMap.get("massa_kg")));
            rst.append(String.format(" %-"+columnWidths[3]+"s │", orbitaMap.get("distancia_mitjana_km")));
            rst.append("\n");
        }

        rst.append("└");
        for (int i = 0; i < headers.length; i++) {
            rst.append("─".repeat(columnWidths[i] + 2));
            if (i < headers.length - 1) {
                rst.append("┴");
            } 
            if (i == headers.length - 1) {  
                rst.append("┘");
            }
        }
        rst.append("\n");

        System.out.print(rst); 
        
    }

    /**
     * Crea un HashMap que representa una massa d'aigua amb característiques addicionals.
     * 
     * @param nom Nom del mar o oceà.
     * @param tipus Tipus (mar o oceà).
     * @param superficie_km2 Superfície en km².
     * @param profunditat_max_m Profunditat màxima en metres.
     * @param caracteristiques Llista d'informació addicional sobre el mar o oceà.
     * @return Un HashMap amb les dades del mar o oceà.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testCrearMassaAigua
     */
    public static HashMap<String, Object> crearMassaAigua(String nom, String tipus, double superficie_km2, double profunditat_max_m, ArrayList<String> caracteristiques) {
        HashMap<String, Object> massaAigua = new HashMap<>();
        return massaAigua;
    }

    /**
     * Genera un arxiu JSON amb la informació de mars i oceans. Identat amb "4 espais":
     * [
     *     {
     *         "nom": "Oceà Pacífic",
     *          "tipus": "oceà",
     *          "profunditat_max_m": 10924,
     *          "superficie_km2": 1.68723E8,
     *          "caracteristiques": [
     *              "És l'oceà més gran del món",
     *              "Conté la fossa de les Marianes, la més profunda del món",
     *              "Conté una illa de plàstics contaminants."
     *         ]
     *      },
     *      {
     *          "nom": "Oceà Atlàntic",
     *          "tipus": "oceà", ...
     * 
     * @param filePath Ruta de l'arxiu JSON a crear.
     * @throws IOException Si hi ha algun problema amb l'escriptura de l'arxiu.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0202#testValidarFormatJSON
     */
    public static void generarJSON(ArrayList<HashMap<String, Object>> dades, String filePath) throws IOException {

    }
}