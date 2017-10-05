import java.util.ArrayList;
import data.*;
import visual.AnalizerWindow;

public class Main {

	public static void main(String[] args) {
		AnalizerWindow window = new AnalizerWindow();
		GdfAnalyzer gdf = window.getGdfAnalizer();
		ArrayList<GdfNode> nodeList = gdf.getNodeList();
		for(GdfNode node : nodeList) {
			window.println(node.toString());
		}
//		String goToNode = "AmericanIdol";
//		String goToNode = "TheSimpsons";
		String goToNode = "TheMobDoctor";
		Graph graph = new Graph();
		System.out.println("BFS");
		graph.bfsToNode(nodeList.get(0),goToNode);
		graph.reset(nodeList);
		System.out.println("DFS");
		ArrayList<String> nodesInPath = new ArrayList<>();
		graph.dfsToNode(nodeList.get(0), goToNode, nodesInPath );
		graph.reset(nodeList);
		graph.pageRank(nodeList, 5);
	}

}