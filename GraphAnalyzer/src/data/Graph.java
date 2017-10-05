package data;
import java.util.*;

import data.*;


public class Graph{
	

	
	public ArrayList<GdfNode> reset(ArrayList<GdfNode> graph){  
		for(GdfNode node : graph) {
			node.resetNode();
		}
		return graph;
    }
	
	private void pageRankReducer(GdfNode currentNode) {
		double d = 0.85; //Damping factor
		int accumulated = 0;
		for(GdfNode node : currentNode.getChildNodes()) {
			accumulated += node.getPageRank()/node.getAllConnectedNodes().size();
			float newPageRank = (float) ((1-d)+(d)*accumulated);
			node.setPageRank(newPageRank);
		}
		
	}

	public void pageRank(ArrayList<GdfNode> graph, int iterations) {
		for(int i = 0; i<iterations; i++) {
			for(GdfNode node : graph) {
				pageRankReducer(node);
			}
		}
		System.out.println("Node name \t PageRank\t" );
		for(GdfNode node : graph) {
			System.out.println(node.getUsername()+ " \t" +node.getPageRank()+ " \t");
		}
	}
	
	
	
    public void dfs(GdfNode root){       
        if(root == null) return;

        root.setVisited(true); 

        for(GdfNode n: root.getChildNodes()){
            if(!n.isVisited()){
                dfs(n);
            }
        }
    }
    
    public void printPath(ArrayList<String> path) {
    	int count = 0;
    	StringBuilder sb = new StringBuilder();
    		for(String node : path) {
    			sb.append(node);
    			if(count < path.size()-1) {
    				sb.append(" --> ");
    			}
			count++;
		}
    		sb.append("\nFound after visit "+ (count-1) + " nodes.\n");
    		System.out.println(sb);
    }
    
    public void dfsToNode(GdfNode root, String destinyUsername, ArrayList<String> path){       

        if(root == null) return;
        root.setVisited(true);
        path.add(root.getUsername());
        
        if(root.getUsername().equals(destinyUsername)) {
        		printPath(path);
    			return;
        }
        for(GdfNode n: root.getChildNodes()){
            if(!n.isVisited()){
            	dfsToNode(n, destinyUsername, path);
            }
        }
    }

    public void bfs(GdfNode root){
        Queue<GdfNode> queue = new LinkedList<GdfNode>();
        if(root == null) return;
        root.setVisited(true);
        queue.add(root);
        while(!queue.isEmpty())
        {
        	GdfNode r = queue.remove(); 
            for(GdfNode n: r.getChildNodes())
            {
                if(!n.isVisited())
                {
                    queue.add(n);
                    n.setVisited(true);
                }
            }
        }
    }
    
    public void bfsToNode(GdfNode root, String destinyUsername){ 
        if(root == null) return;
        
        ArrayList<String> path = new ArrayList<>();
        Queue<GdfNode> queue = new LinkedList<GdfNode>();
        
        root.setVisited(true);
        queue.add(root);

        while(!queue.isEmpty()){
        		GdfNode r = queue.remove(); 
        		path.add(r.getUsername());

        	
        	 if(r.getUsername().equals(destinyUsername)) {
     		printPath(path);
 			return;
        	 }

            for(GdfNode n: r.getChildNodes()){
                if(!n.isVisited()){
                    queue.add(n);
                    n.setVisited(true);
                }
            }
        }
    }
    
    
    
}