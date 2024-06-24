package grafos;
import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {

  public static void main(String[] args) {
    // CARGAR GRAFO
    TGrafoNoDirigido gndej1g1 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
        "ej1p5g1_vertices.txt",
        "ej1p5g1_aristas.txt",
        false, TGrafoNoDirigido.class);

    // CARGAR GRAFO
    TGrafoNoDirigido gndej1g2 = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
        "ej1p5g2_vertices.txt",
        "ej1p5g2_aristas.txt",
        false, TGrafoNoDirigido.class);

    // PRIM
    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    TGrafoNoDirigido prim1 = gndej1g1.Prim();
    // AAM
    Double[][] matrizAdyacenciasPrim1 = UtilGrafos.obtenerMatrizCostos(prim1.getVertices());
    UtilGrafos.imprimirMatrizMejorado(matrizAdyacenciasPrim1, prim1.getVertices(), "AAM Prim");

    TGrafoNoDirigido prim2 = gndej1g2.Prim();
    // AAM
    Double[][] matrizAdyacenciasPrim2 = UtilGrafos.obtenerMatrizCostos(prim2.getVertices());
    UtilGrafos.imprimirMatrizMejorado(matrizAdyacenciasPrim2, prim2.getVertices(), "AAM Prim");

    // KRUSKAL
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------
    TGrafoNoDirigido kruskal1 = gndej1g1.Kruskal();
    // AAM
    Double[][] matrizAdyacenciasKruskal1 = UtilGrafos.obtenerMatrizCostos(kruskal1.getVertices());
    UtilGrafos.imprimirMatrizMejorado(matrizAdyacenciasPrim1, prim1.getVertices(), "AAM Kruskal");

    TGrafoNoDirigido kruskal2 = gndej1g2.Kruskal();
    // AAM
    Double[][] matrizAdyacenciasKruskal2 = UtilGrafos.obtenerMatrizCostos(kruskal2.getVertices());
    UtilGrafos.imprimirMatrizMejorado(matrizAdyacenciasPrim2, prim2.getVertices(), "AAM Kruskal");

    // COMPARA LA SALIDA DE PRIM CON KRUSKAL: AMBAS ARROJAN EL MISMO ARBOL ABARCADOR
    // DE COSTOS MÍNIMOS, COMO DEBE SER
    // ESTRUCTURAS DE DATOS UTILIZADA EN KRUSKAL: aprovechando los métodos de hallar
    // caminos desarrollados
    // para grafo dirigido, se implementó listas enlazadas ya que son una estructura
    // muy optimizada en cuanto a costo en memoria.
    // Para hallar si eran aristas de distinto componente conexo o del mismo, se
    // hizo recorriendo las aristas ordenadas por costo y hallando los
    // posibles caminos existentes, para así ver si añadir la arista o no.
    // ORDEN: primeramente, para ordenar las aristas, es O(a). A continuación,
    // tenemos un for que recorre las aristas ordenadas (O(a)). Dentro del bucle
    // se llama a todosLosCaminos() que tiene O(v) en el peor caso. Los insertar
    // dentro del bucle, por regla de la suma, no tienen mayor trascendencia. Por
    // lo que al final, el algoritmo quedará, por regla de la multiplicación O(a*v).
    // ¿puedes encontrar otras alternativas de implementación mejores? Utilizando un
    // mapa ordenado que contenga las aristas hubiera sido otra muy buena opción
    // ¿cuán importante es el consumo de memoria asociado? al haber tantas
    // estrcuturas auxiliares, es importante ir por una estructura que sea
    // flexible y de bajo costo en memoria, como lo son las listas enlazadas.
  }
}
