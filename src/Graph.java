import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;

public class Graph {
    private HashSet<Edge> _edges;

    public Graph() {
        _edges = new HashSet<Edge>();
    }

    public void setEdges(HashSet<Edge> edges){
        _edges = edges;
    }

    public void addEdge(Edge edge){
        _edges.add(edge);
    }

    public HashMap<String, Integer> recommendProduct(ArrayList<String> products){
        HashMap<String, Integer> totalOccurences = new HashMap<String, Integer>();
        ArrayList<Edge> matchedEdges = new ArrayList<Edge>();

        for(Edge edge: _edges){
            for(String product: products){
                if(edge.getTo().getValue().contains(product)){
                    matchedEdges.add(edge);
                }
            }
        }

        for(Edge edge: matchedEdges){
            List<String> splittedProducts = edge.getTo().getValue().contains(",") ?
            Arrays.asList(edge.getTo().getValue().split(",")) :
            Arrays.asList(edge.getTo().getValue());

            for(String product: splittedProducts){
                if(products.contains(product)){
                    continue;
                }

                if(totalOccurences.containsKey(product)){
                    Integer oldOcurrence = totalOccurences.get(product) + 1;
    
                    totalOccurences.put(product, oldOcurrence);
    
                    continue;
                }

                totalOccurences.put(product, 1);
            }
        }

        return totalOccurences;
    }

    private String getMaxOccurence(HashMap<String, Integer> ocurrences){
        Integer maxItemValue = Collections.max(ocurrences.values());

        for(Entry<String, Integer> entry: ocurrences.entrySet()){
            if(ocurrences.get(entry.getKey()) == maxItemValue){
                return entry.getKey();
            }
        }

        return null;
    }

    public String filter(ArrayList<String> products, String filter){
        HashMap<String, Integer> recommendedProduct = recommendProduct(products);

        for(Entry<String, Integer> entry: recommendedProduct.entrySet()){
            for(Edge edge: _edges){
                if(edge.getTo().getValue().contains(entry.getKey()) && edge.getFrom().getValue().contains(getEdge(filter).getFrom().getValue())){
                    return entry.getKey();
                }
            }
        }

        return null;
    }

    public Edge getEdge(String edgeValue){
        for(Edge edge: _edges){
            if(edge.getTo().getValue().contains(edgeValue)){
                return edge;
            }
        }

        return null;
    }

    public Integer count(ArrayList<String> filters){

        Map<String, List<Edge>> groupedByEdge = _edges.stream().collect(Collectors.groupingBy(token -> token.getFrom().getValue()));

        ArrayList<String> foundEdges = new ArrayList<String>();

        for(Entry<String, List<Edge>> edge: groupedByEdge.entrySet()){
            
            Integer matchCounter = 0;

            for(String filter: filters){
                if(edge.getValue().stream().anyMatch(x -> x.getTo().getValue().contains(filter))){
                    matchCounter += 1;
                }
            }

            if(matchCounter == filters.size()){
                foundEdges.add(edge.getKey());
            }
        }

        return foundEdges.size();
    }
}
